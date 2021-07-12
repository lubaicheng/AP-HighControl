package com.example.androidpractice_highcontrol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class MainActivity extends AppCompatActivity {
    ListView mylist=null;
    private ImageView iv=null;
    private TextView title,price;

    //定义适配器中的数组内容
    //图片资源
    private int[] icons={R.drawable.apple,R.drawable.cake,R.drawable.table};
    //标题资源
    private String[] tiles={"苹果","蛋糕","桌子"};
    //价格资源
    private String[] prices={"12元","20元","30元"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist=findViewById(R.id.mylist);
        MyAdapter md=new MyAdapter();
        mylist.setAdapter(md);
    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {//获取Item条目的总数
            return tiles.length;
        }

        @Override
        public Object getItem(int position) {//position记录当前Item的序号，序号从0开始，getItem获取某个Item的对象。
            return tiles[position];
        }

        @Override
        public long getItemId(int position) {//获取选中的Item的编号。
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//            //用于配置Listview需要加载的内容。
//            // 获取相应position对应的Item视图，position是之前Item位置，convertView用于复用旧视图，parent用于加载XML布局
//            //将Item的布局文件解析成为view的类的对象
//            View view=View.inflate(MainActivity.this,R.layout.shoopingmarket,null);
//            title=view.findViewById(R.id.title);
//            iv=view.findViewById(R.id.iv);
//            price=view.findViewById(R.id.price);
//            title.setText(tiles[position]);
//            price.setText(prices[position]);
//            iv.setBackgroundResource(icons[position]);
//            return view;
            //改进的listview写法
            ViewHolder holder=null;
            //convertView:用户缓存item视图的一个对象。
            if(convertView==null)
            {
                convertView=View.inflate(MainActivity.this,R.layout.shoopingmarket,null);
                holder=new ViewHolder();
                holder.title=convertView.findViewById(R.id.title);
                holder.price=convertView.findViewById(R.id.price);
                holder.iv=convertView.findViewById(R.id.iv);
                convertView.setTag(holder);

            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.title.setText(tiles[position]);
            holder.price.setText(prices[position]);
            holder.iv.setBackgroundResource(icons[position]);
            return convertView;
        }
    }
    static class ViewHolder{
        TextView title;
        TextView price;
        ImageView iv;
    }
}
