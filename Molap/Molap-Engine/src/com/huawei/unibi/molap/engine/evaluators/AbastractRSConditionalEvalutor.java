package com.huawei.unibi.molap.engine.evaluators;

import java.util.ArrayList;
import java.util.List;

import com.huawei.unibi.molap.constants.MolapCommonConstants;
import com.huawei.unibi.molap.engine.expression.ColumnExpression;
import com.huawei.unibi.molap.engine.expression.DataType;
import com.huawei.unibi.molap.engine.expression.Expression;
import com.huawei.unibi.molap.engine.expression.conditional.BinaryConditionalExpression;
import com.huawei.unibi.molap.engine.expression.conditional.ConditionalExpression;
import com.huawei.unibi.molap.engine.filters.measurefilter.util.FilterUtil;
import com.huawei.unibi.molap.engine.schema.metadata.FilterEvaluatorInfo;


public abstract class AbastractRSConditionalEvalutor implements FilterEvaluator
{
    protected List<DimColumnEvaluatorInfo> dimColEvaluatorInfoList;
    
    private Expression exp;

    private String defaultValue;
    
    private int surrogate;
    
    private boolean isExpressionResolve;
    
    private boolean isIncludeFilter;
    
    public AbastractRSConditionalEvalutor(Expression exp,String defaultValue,int surrogate, boolean isExpressionResolve, boolean isIncludeFilter)
    {
        this.dimColEvaluatorInfoList = new ArrayList<DimColumnEvaluatorInfo>(
                MolapCommonConstants.DEFAULT_COLLECTION_SIZE);
        this.exp = exp;
        this.defaultValue = defaultValue;
        this.surrogate=surrogate;
        this.isExpressionResolve=isExpressionResolve;
        this.isIncludeFilter=isIncludeFilter;
    }
    
    @Override
    public void resolve(FilterEvaluatorInfo info)
    {
        DimColumnEvaluatorInfo dimColumnEvaluatorInfo = new DimColumnEvaluatorInfo();
        if(!this.isExpressionResolve && exp instanceof BinaryConditionalExpression)
        {
            BinaryConditionalExpression binaryConditionalExpression = (BinaryConditionalExpression)exp;
            Expression left = binaryConditionalExpression.getLeft();
            Expression right = binaryConditionalExpression.getRight();
            if(left instanceof ColumnExpression)
            {
                ColumnExpression columnExpression = (ColumnExpression)left;
                if(columnExpression.getDataType().equals(DataType.TimestampType))
                {
                    isExpressionResolve = true;
                }
                else
                {
                    // If imei=imei comes in filter condition then we need to
                    // skip processing of right expression.
                    // This flow has reached here assuming that this is a single
                    // column expression.
                    // we need to check if the other expression contains column
                    // expression or not in depth.
                    if(checkIfExpressionContainsColumn(right))
                    {
                        isExpressionResolve = true;
                    }
                    else
                    {
                        dimColumnEvaluatorInfo.setColumnIndex(columnExpression.getDim().getOrdinal());
                        // dimColumnEvaluatorInfo
                        // .setNeedCompressedData(info.getSlices().get(info.getCurrentSliceIndex())
                        // .getDataCache(info.getFactTableName()).getAggKeyBlock()[columnExpression.getDim()
                        // .getOrdinal()]);
                        dimColumnEvaluatorInfo.setFilterValues(FilterUtil.getFilterListForRS(right, columnExpression,
                                defaultValue, surrogate));
                    }
                }
            }
            else if(right instanceof ColumnExpression)
            {
                ColumnExpression columnExpression = (ColumnExpression)right;
                if(columnExpression.getDataType().equals(DataType.TimestampType))
                {
                    isExpressionResolve = true;
                }
                else
                {

                    // If imei=imei comes in filter condition then we need to
                    // skip processing of right expression.
                    // This flow has reached here assuming that this is a single
                    // column expression.
                    // we need to check if the other expression contains column
                    // expression or not in depth.
                    if(checkIfExpressionContainsColumn(left))
                    {
                        isExpressionResolve = true;
                    }
                    else
                    {
                        dimColumnEvaluatorInfo.setColumnIndex(columnExpression.getDim().getOrdinal());
                        // dimColumnEvaluatorInfo
                        // .setNeedCompressedData(info.getSlices().get(info.getCurrentSliceIndex())
                        // .getDataCache(info.getFactTableName()).getAggKeyBlock()[columnExpression.getDim()
                        // .getOrdinal()]);
                        dimColumnEvaluatorInfo.setFilterValues(FilterUtil.getFilterListForRS(left, columnExpression,
                                defaultValue, surrogate));
                    }
                }
            }
        }
        if(this.isExpressionResolve && exp instanceof ConditionalExpression)
        {
            ConditionalExpression conditionalExpression = (ConditionalExpression)exp;
            List<ColumnExpression> columnList = conditionalExpression.getColumnList();
            dimColumnEvaluatorInfo.setColumnIndex(columnList.get(0).getDim().getOrdinal());
//            dimColumnEvaluatorInfo.setNeedCompressedData(info.getSlices().get(info.getCurrentSliceIndex())
//                    .getDataCache(info.getFactTableName()).getAggKeyBlock()[columnList.get(0).getDim().getOrdinal()]);
            dimColumnEvaluatorInfo.setFilterValues(FilterUtil.getFilterListForAllMembersRS(exp, columnList.get(0),defaultValue,surrogate, isIncludeFilter));
        }
        dimColEvaluatorInfoList.add(dimColumnEvaluatorInfo);
    }

    @Override
    public FilterEvaluator getLeft()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FilterEvaluator getRight()
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
     * This method will check if a given expression contains a column expression recursively.
     * 
     * @param right
     * @return
     */
    private boolean checkIfExpressionContainsColumn(Expression expression)
    {
        if(expression instanceof ColumnExpression)
        {
            return true;
        }
        for(Expression child: expression.getChildren())
        {
            if(checkIfExpressionContainsColumn(child))
            {
                return true;
            }
        }
        
        return false;
    }

}
