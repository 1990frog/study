package action.mvc.mapper;

import action.mvc.domain.entity.Product;
import action.mvc.domain.entity.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface ProductMapper {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    @Select("select * from product order by id")
    List<Product> queryAllWithRowBounds(RowBounds rowBounds);

    @Select("select * from product order by id")
    List<Product> queryAllWithParam(@Param("pageNum") int pageNum,
                                  @Param("pageSize") int pageSize);
}