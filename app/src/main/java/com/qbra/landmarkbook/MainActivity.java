package com.qbra.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.qbra.landmarkbook.databinding.ActivityDetailsBinding;
import com.qbra.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity
{

    private ActivityMainBinding binding;
    ArrayList<Landmark> foodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Landmark makarna = new Landmark("Makarna", "Makarna, geleneksel İtalyan mutfağının temel besini ve ulusal yemeğidir. İlk defa 1154 yılında Sicilya'da ortaya çıkmıştır.", R.drawable.makarna);
        Landmark manti = new Landmark("Mantı", "Mantı, çeşitli baharatlarla çeşnilendirilen kıymanın, küçük hamur parçalarının içine konulması ve bu hamur parçalarının suda haşlanması ile yapılan yemektir. Türk mutfağının olduğu kadar Orta Asya mutfaklarının da bir parçası olan mantı, eski SSCB ülkelerinde de popüler bir yiyecektir.", R.drawable.manti);
        Landmark sinitzel = new Landmark("Şinitzel", "Şinitzel, Avusturya mutfağından, gayet ince kesilmiş bir dilim dana, domuz veya tavuk etinin sırasıyla una, yumurta sarısına ve galeta ununa bandırılarak kızgın yağda kızartılmasıyla yapılan bir yemek türüdür. Avusturya'da yaygın olarak yapılan Avrupa kökenli fast food türü yemek, nugget ile benzer özellikler göstermektedir. Almanya'da da oldukça çok tüketilir.", R.drawable.sinitzel);
        Landmark domatesCorbasi = new Landmark("Domates Çorbası", "Domates çorbası, ana malzemesi domates olan bir çorbadır. Sıcak veya soğuk olarak servis edilebilir ve çeşitli şekillerde yapılabilir. Dokusu pürüzsüz olabilir ve domates parçaları, krema, tavuk veya sebze suyu, erişte, diğer sebze parçaları ve köfte içeren tarifler de vardır.", R.drawable.domatescorbasi);

        foodList.add(makarna);
        foodList.add(manti);
        foodList.add(sinitzel);
        foodList.add(domatesCorbasi);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FoodAdapter foodAdapter = new FoodAdapter(foodList);
        binding.recyclerView.setAdapter(foodAdapter);

        /*
        //ADAPTER - LISTVIEW - MAPPING (verimsiz yöntem)
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, foodList.stream().map(landmark -> landmark.name).collect(Collectors.toList()));
        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this, foodList.get(i).name,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("foodInfo", foodList.get(i));
                startActivity(intent);
            }
        });
         */
    }
}