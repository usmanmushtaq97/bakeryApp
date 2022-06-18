package com.tss.bakeryapp.DBhelperclasses;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName = "CartsItem")
public class CartsTableModel implements Serializable {
    //primary key auto increament
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cart_Id")
    private int mcartsid;
    // product id which get from server
    @ColumnInfo(name = "title")
    private String mproductname;
    @ColumnInfo(name ="quantity")
    private int mqunatity_product;
    @ColumnInfo(name = "price")
    private int mprice;
    @ColumnInfo(name = "subprice")
    private int subprice;
    @ColumnInfo(name = "size")
    private String psize;
    public CartsTableModel() {
    }

    public CartsTableModel(String mproductname, int mqunatity_product, int mprice , int subpricr, String psize ) {
        this.mproductname = mproductname;
        this.mqunatity_product = mqunatity_product;
        this.mprice = mprice;
        this.subprice = subpricr;
        this.psize = psize;
    }

    public int getMcartsid() {
        return mcartsid;
    }

    public void setMcartsid(int mcartsid) {
        this.mcartsid = mcartsid;
    }

    public String getMproductname() {
        return mproductname;
    }

    public void setMproductname(String mproductname) {
        this.mproductname = mproductname;
    }

    public int getMqunatity_product() {
        return mqunatity_product;
    }

    public void setMqunatity_product(int mqunatity_product) {
        this.mqunatity_product = mqunatity_product;
    }

    public int getMprice() {
        return mprice;
    }

    public void setMprice(int mprice) {
        this.mprice = mprice;
    }

    public int getSubprice() {
        return subprice;
    }

    public void setSubprice(int subprice) {
        this.subprice = subprice;
    }

    public String getPsize() {
        return psize;
    }

    public void setPsize(String psize) {
        this.psize = psize;
    }
}
