package Hoang.Long;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {
    @Insert(onConflict = REPLACE)
    void insertUser(UserEntity userEntity);
    @Update
    void updateUser(UserEntity userEntity);
    @Delete
    void deleteUser(UserEntity userEntity);
    @Query("SELECT * FROM User WHERE id =:id")
    UserEntity getUser(int id);
    @Query("DELETE FROM User")
    void deleteAll();
}
