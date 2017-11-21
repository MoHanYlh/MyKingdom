package io.imking.core.mapper;

import io.imking.core.domain.User;
import io.imking.core.domain.UserExample;
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

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user
     *
     * @mbggenerated
     */
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    int countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user
     *
     * @mbggenerated
     */
    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user
     *
     * @mbggenerated
     */
    @Delete({
        "delete from kd_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user
     *
     * @mbggenerated
     */
    @Insert({
        "insert into kd_user (id, userName, ",
        "pwd, email, slat, ",
        "avatar, sex, phone, ",
        "brithday, nickName, ",
        "trueName, status, ",
        "createTime, updateTime, ",
        "address, workyears, ",
        "job, dream, introduce, ",
        "balance, points)",
        "values (#{id,jdbcType=BIGINT}, #{userName,jdbcType=VARCHAR}, ",
        "#{pwd,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{slat,jdbcType=VARCHAR}, ",
        "#{avatar,jdbcType=VARCHAR}, #{sex,jdbcType=TINYINT}, #{phone,jdbcType=VARCHAR}, ",
        "#{brithday,jdbcType=VARCHAR}, #{nickName,jdbcType=VARCHAR}, ",
        "#{trueName,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{address,jdbcType=VARCHAR}, #{workyears,jdbcType=INTEGER}, ",
        "#{job,jdbcType=VARCHAR}, #{dream,jdbcType=VARCHAR}, #{introduce,jdbcType=VARCHAR}, ",
        "#{balance,jdbcType=BIGINT}, #{points,jdbcType=BIGINT})"
    })
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user
     *
     * @mbggenerated
     */
    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user
     *
     * @mbggenerated
     */
    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userName", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="slat", property="slat", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="brithday", property="brithday", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickName", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="trueName", property="trueName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="workyears", property="workyears", jdbcType=JdbcType.INTEGER),
        @Result(column="job", property="job", jdbcType=JdbcType.VARCHAR),
        @Result(column="dream", property="dream", jdbcType=JdbcType.VARCHAR),
        @Result(column="introduce", property="introduce", jdbcType=JdbcType.VARCHAR),
        @Result(column="balance", property="balance", jdbcType=JdbcType.BIGINT),
        @Result(column="points", property="points", jdbcType=JdbcType.BIGINT)
    })
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "id, userName, pwd, email, slat, avatar, sex, phone, brithday, nickName, trueName, ",
        "status, createTime, updateTime, address, workyears, job, dream, introduce, balance, ",
        "points",
        "from kd_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userName", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="slat", property="slat", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="brithday", property="brithday", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickName", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="trueName", property="trueName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="workyears", property="workyears", jdbcType=JdbcType.INTEGER),
        @Result(column="job", property="job", jdbcType=JdbcType.VARCHAR),
        @Result(column="dream", property="dream", jdbcType=JdbcType.VARCHAR),
        @Result(column="introduce", property="introduce", jdbcType=JdbcType.VARCHAR),
        @Result(column="balance", property="balance", jdbcType=JdbcType.BIGINT),
        @Result(column="points", property="points", jdbcType=JdbcType.BIGINT)
    })
    User selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user
     *
     * @mbggenerated
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user
     *
     * @mbggenerated
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user
     *
     * @mbggenerated
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kd_user
     *
     * @mbggenerated
     */
    @Update({
        "update kd_user",
        "set userName = #{userName,jdbcType=VARCHAR},",
          "pwd = #{pwd,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "slat = #{slat,jdbcType=VARCHAR},",
          "avatar = #{avatar,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=TINYINT},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "brithday = #{brithday,jdbcType=VARCHAR},",
          "nickName = #{nickName,jdbcType=VARCHAR},",
          "trueName = #{trueName,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "address = #{address,jdbcType=VARCHAR},",
          "workyears = #{workyears,jdbcType=INTEGER},",
          "job = #{job,jdbcType=VARCHAR},",
          "dream = #{dream,jdbcType=VARCHAR},",
          "introduce = #{introduce,jdbcType=VARCHAR},",
          "balance = #{balance,jdbcType=BIGINT},",
          "points = #{points,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);
}