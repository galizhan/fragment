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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddingFragment extends Fragment {
    SharedPreferences sp;
    Button addBtn;
    EditText wordEd;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_adding, container, false);
        addBtn = (Button)view.findViewById(R.id.addBtn);
        wordEd = (EditText)view.findViewById(R.id.wordEd);
        sp = this.getActivity().getSharedPreferences("words",Context.MODE_PRIVATE);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("has",(wordEd.getText().toString())+"");
                if(wordEd.getText()!=null && wordEd.getText().toString()!=""){

                    SharedPreferences.Editor ed = sp.edit();
                    int count = sp.getInt("count",0);
                    ed.putString(count+"",wordEd.getText().toString());
                    ed.putInt("count",count+1);
                    ed.commit();
                    wordEd.setText("");
                }
                else{
                    Toast.makeText(view.getContext(),"You haven't wrote any word",Toast.LENGTH_LONG);
                }
            }
        });
        return view;
    }

}
