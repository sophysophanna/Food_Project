package com.sophysophanna.my_project.Helper;

import android.content.Context;
import android.widget.Toast;

import com.sophysophanna.my_project.Domain.FoodDomain;

import java.util.ArrayList;

public class ManagmentCart {

    private Context context;
    private TinyDB tinyDB;

    public ManagmentCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(FoodDomain item){

        ArrayList<FoodDomain> lisfood=getListCart();
        boolean existAlready=false;
        int n=0;
        for (int y=0;y<lisfood.size();y++){
            if(lisfood.get(y).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=y;
                break;
            }

        }
        if (existAlready){
                lisfood.get(n).setNumberInCart(item.getNumberInCart());

        }else {
            lisfood.add(item);
        }
        tinyDB.putListObject("Cartlist",lisfood);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();

    }
    public ArrayList<FoodDomain> getListCart(){

        return tinyDB.getListObject("CartList");
    }

    public void minusNumberFood(ArrayList<FoodDomain> listfood, int position,ChangeNumberItemsListener changeNumberItemsListener){
        if (listfood.get(position).getNumberInCart()==1){
            listfood.remove(position);
        }else {
            listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart()-1);
        }
        tinyDB.putListObject("CarList",listfood);
        changeNumberItemsListener.changed();
    }
    public void plusNumberFood(ArrayList<FoodDomain> listfood,int position,ChangeNumberItemsListener changeNumberItemsListener){
        listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart()+1);
        tinyDB.putListObject("CartList", listfood);
        changeNumberItemsListener.changed();
    }
    public Double getTotalFee(){
        ArrayList<FoodDomain> listfood2=getListCart();
        double fee=0;
        for (int i = 0; i < listfood2.size(); i++) {
            fee=fee+(listfood2.get(i).getPrice()*listfood2.get(i).getNumberInCart());
        }
        return fee;
        }
    }


