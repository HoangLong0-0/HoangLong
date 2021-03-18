package Hoang.Long;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class UserEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "name")
    public  String name;
    @ColumnInfo(name = "email")
    public  String email;
    @ColumnInfo(name = "phone")
    public  String phone;
    @ColumnInfo(name = "gender")
    public  String gender;

}
