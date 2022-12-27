package com.treelist;

import static com.treelist.MyTreeRecyclerAdapter.ITEM_TYPE_FILE;
import static com.treelist.MyTreeRecyclerAdapter.ITEM_TYPE_FOLDER;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.multilevel.treelist.Node;
import com.multilevel.treelist.TreeRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    protected List<Node> mDatas = new ArrayList<>();
    private TreeRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        RecyclerView mTree = (RecyclerView) findViewById(R.id.list);
        mTree.setLayoutManager(new LinearLayoutManager(this));
        //第四个参数  默认展开层级数 0为不展开
        mAdapter = new MyTreeRecyclerAdapter(this);

        mTree.setAdapter(mAdapter);
        mAdapter.addData(initDatas());

        // TODO: 2022/12/27 checkbox与选中挂钩 
        // TODO: 2022/12/27 全部选中 
        // TODO: 2022/12/27 点击效果
    }


    /**
     * 显示选中数据
     */
//    public void clickShow(View v) {
//        StringBuilder sb = new StringBuilder();
//        final List<Node> allNodes = mAdapter.getAllNodes();
//        for (int i = 0; i < allNodes.size(); i++) {
//            if (allNodes.get(i).isChecked()) {
//                sb.append(allNodes.get(i).getName() + ",");
//            }
//        }
//        String strNodesName = sb.toString();
//        if (!TextUtils.isEmpty(strNodesName)) {
//            Toast.makeText(this, strNodesName.substring(0, strNodesName.length() - 1), Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    public void delete(View view) {
//        if (mAdapter.getAllNodes().size() > 0) {
//            mAdapter.removeData(mAdapter.getAllNodes().get(mAdapter.getAllNodes().size() - 1));
//        }
//    }
    public List<Node> initDatas() {
        // id , pid , label , 其他属性
        mDatas.add(new Node("192", "0", "中控", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("196", "184", "投影机分组195", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("197", "184", "投影机分组196", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("198", "179", "投影机分组197", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("199", "186", "投影机分组198", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("200", "186", "投影机分组199", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("201", "179", "投影机分组200", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("203", "191", "投影机分组201", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("204", "203", "投影机分组203", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("217", "193", "投影机分组204", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("219", "192", "A区", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("220", "0", "L分组", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("221", "219", "投影机分组220", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("222", "0", "投影机分组221", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("223", "0", "投影机分组222", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("225", "226", "投影机分组224", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("228", "0", "中控", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("231", "0", "投影机分组230", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("236", "0", "投影机分组235", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("239", "0", "u8888", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("240", "0", "L1+  勿删", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("241", "240", "投影机分组240", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("242", "0", "投影机分组241", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("243", "0", "投影机分组242", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("248", "0", "投影机分组243", ITEM_TYPE_FOLDER));
        mDatas.add(new Node("1", "217", "设备-UDP", ITEM_TYPE_FILE));
        mDatas.add(new Node("2", "231", "设备-S4mini-229", ITEM_TYPE_FILE));
        mDatas.add(new Node("3", "219", "设备4K(TCP)-111", ITEM_TYPE_FILE));
        mDatas.add(new Node("4", "221", "设备4K(TCP)-125", ITEM_TYPE_FILE));
        mDatas.add(new Node("5", "222", "设备L5(UDP)-150", ITEM_TYPE_FILE));
        mDatas.add(new Node("6", "222", "设备L1+(TCP)-200", ITEM_TYPE_FILE));

        return mDatas;
    }
}
