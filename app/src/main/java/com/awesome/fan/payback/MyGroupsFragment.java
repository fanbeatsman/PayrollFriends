package com.awesome.fan.payback;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

/**
 * A placeholder fragment containing a simple view.
 */
public class MyGroupsFragment extends ListFragment implements AdapterView.OnItemClickListener {

    String[] itemname = {
            "Ski Trip",
            "Ti5"
    };

    public MyGroupsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //this.getListAdapter();

       // ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.getListView(), R.layout.list_group, R.id.Itemname, itemname);

       // this.setListAdapter(arrayAdapter);
        return inflater.inflate(R.layout.fragment_my_groups, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_group, R.id.Itemname, itemname);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id){
        //String item = ((TextView)view).getText().toString();
        Toast.makeText(getActivity(), "Item: " + itemname[position], Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this.getActivity(), Groups.class);
        try {
            wait(2000);
        } catch (Exception e){
            //noop
        }
        HashMap groupProperties = new HashMap();
        groupProperties.put("Group",itemname[position]);
        intent.putExtra("com.awesome.fan.payback.GROUP_PROPERTIES",groupProperties);
        startActivity(intent);
    }
}
