package io.imking.core.mapper;

import io.imking.core.domain.UserRole;
import io.imking.core.domain.UserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user_role
     *
     * @mbggenerated
     */
    @SelectProvider(type=UserRoleSqlProvider.class, method="countByExample")
    int countByExample(UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user_role
     *
     * @mbggenerated
     */
    @DeleteProvider(type=UserRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user_role
     *
     * @mbggenerated
     */
    @Delete({
        "delete from kd_user_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user_role
     *
     * @mbggenerated
     */
    @Insert({
        "insert into kd_user_role (id, userid, ",
        "roleid)",
        "values (#{id,jdbcType=INTEGER}, #{userid,jdbcType=BIGINT}, ",
        "#{roleid,jdbcType=BIGINT})"
    })
    int insert(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user_role
     *
     * @mbggenerated
     */
    @InsertProvider(type=UserRoleSqlProvider.class, method="insertSelective")
    int insertSelective(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user_role
     *
     * @mbggenerated
     */
    @SelectProvider(type=UserRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.BIGINT),
        @Result(column="roleid", property="roleid", jdbcType=JdbcType.BIGINT)
    })
    List<UserRole> selectByExample(UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user_role
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "id, userid, roleid",
        "from kd_user_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.BIGINT),
        @Result(column="roleid", property="roleid", jdbcType=JdbcType.BIGINT)
    })
    UserRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user_role
     *
     * @mbggenerated
     */
    @UpdateProvider(type=UserRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user_role
     *
     * @mbggenerated
     */
    @UpdateProvider(type=UserRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user_role
     *
     * @mbggenerated
     */
    @UpdateProvider(type=UserRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user_role
     *
     * @mbggenerated
     */
    @Update({
        "update kd_user_role",
        "set userid = #{userid,jdbcType=BIGINT},",
          "roleid = #{roleid,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserRole record);
}