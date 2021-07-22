package br.com.cassio.ribeiro.teste.listarandomparimpar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

import br.com.cassio.ribeiro.teste.listarandomparimpar.adapter.ListaAdapter;

public class MainActivity extends AppCompatActivity {

    private static final int LENGHT = 10;
    private static final int MAX_LENGHT = 10;
    private RecyclerView mRecyclerView;

    ArrayList<Integer> arrayPar = new ArrayList<>();
    ArrayList<Integer> arrayImpar = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_gerar).setOnClickListener(v -> {
            mGenerateList();
        });

        mRecyclerView = findViewById(R.id.rv_lista_par_impar);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void mGenerateList() {
        ListaAdapter adapter = new ListaAdapter(gerarListaDeDuplas());
        mRecyclerView.setAdapter(adapter);
    }

    private ArrayList<ArrayList<Integer>> gerarListaDeDuplas() {

        segundoExercicio();

        ArrayList<ArrayList<Integer>> listaDeDupla = new ArrayList<>();

        while ((arrayPar != null && !arrayPar.isEmpty()) || (arrayImpar != null && !arrayImpar.isEmpty())) {

            // par na pos 0 e impar na pos 1
            ArrayList<Integer> mDupla = new ArrayList<>();
            if(arrayPar!= null && !arrayPar.isEmpty()){
                mDupla.add(0, arrayPar.remove(0));
            }else{
                mDupla.add(0, -1);
            }

            if(arrayImpar!= null && !arrayImpar.isEmpty()){
                mDupla.add(1, arrayImpar.remove(0));
            }else{
                mDupla.add(1, -1);
            }

            listaDeDupla.add(mDupla);
        }

        return listaDeDupla;
    }

    public void segundoExercicio(){

        Random rn = new Random();
        for(int i = 0; i < LENGHT; i++){
            int mCurrentNumber = rn.nextInt(MAX_LENGHT +1);
            if(mCurrentNumber % 2 == 0){
                arrayPar.add(mCurrentNumber);
            }else{
                arrayImpar.add(mCurrentNumber);
            }
        }
    }
}