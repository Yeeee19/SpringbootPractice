package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class StockEntity implements Serializable {
      private Integer id;
      private String stock;
      private Date tradeDate;
      private Integer volume;
      private Integer price;

      public Integer getId() { return id; }

      public void setId(Integer id) {
            this.id = id;
      }

      public String getStock() {
            return stock;
      }

      public void setStock(String stock) {
            this.stock = stock;
      }

      public Date getTradeDate() {
            return tradeDate;
      }

      public void setTradeDate(Date tradeDate) {
            this.tradeDate = tradeDate;
      }

      public Integer getVolume() {
            return volume;
      }

      public void setVolume(Integer volume) {
            this.volume = volume;
      }

      public Integer getPrice() {
            return price;
      }

      public void setPrice(Integer price) {
            this.price = price;
      }

      @Override
      public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof StockEntity)) return false;
            StockEntity that = (StockEntity) o;
            return Objects.equals(getId(), that.getId()) && Objects.equals(getVolume(), that.getVolume()) && Objects.equals(getPrice(), that.getPrice()) && Objects.equals(getStock(), that.getStock()) && Objects.equals(getTradeDate(), that.getTradeDate());
      }

      @Override
      public int hashCode() {
            return Objects.hash(getId(), getStock(), getTradeDate(), getVolume(), getPrice());
      }

      @Override
      public String toString() {
            return "StockEntity{" +
                    "id=" + id +
                    ", stock='" + stock + '\'' +
                    ", tradeDate=" + tradeDate +
                    ", volume=" + volume +
                    ", price=" + price +
                    '}';
      }
}
