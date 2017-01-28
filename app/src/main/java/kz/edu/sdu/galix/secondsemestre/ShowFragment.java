package kz.edu.sdu.galix.secondsemestre;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ShowFragment extends Fragment {
    ListView wordsList;
    View view;
    SharedPreferences sp;
    Button refresh;
    String[] words;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_show, container, false);
        sp = this.getActivity().getSharedPreferences("words",Context.MODE_PRIVATE);
        wordsList =(ListView)view.findViewById(R.id.wordList);
        refresh = (Button)view.findViewById(R.id.refreshBtn);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                words = new String[sp.getInt("count",0)];
                for(int i = 0;i<sp.getInt("count",0);i++){
                    Log.d("has",i+" "+sp.getString(i+"",null));
                    words[i]=sp.getString(i+"",null);
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(view.getContext(),R.layout.item,words);
                wordsList.setAdapter(arrayAdapter);
            }
        });
        return view;
    }


}
