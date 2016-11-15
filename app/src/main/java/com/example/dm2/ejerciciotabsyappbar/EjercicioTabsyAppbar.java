package com.example.dm2.ejerciciotabsyappbar;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

public class EjercicioTabsyAppbar extends AppCompatActivity {

    TabHost tabs;
    MenuItem item;
    Menu menu;
    ListView listView1;
    ListView listView2;
    ListView listView3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_tabsy_appbar);
        Resources res = getResources();
        tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();
        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Llamadas", res.getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);
        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Chats", res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);
        spec=tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Contactos", res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);
        tabs.setCurrentTab(1);
        item = (MenuItem) findViewById(R.id.icono);
        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            public void onTabChanged(String s)
            {
                if (s.equals("mitab1"))
                {
                    item = menu.findItem(R.id.icono);
                    item.setIcon(R.drawable.llamadas);
                }
                if (s.equals("mitab2"))
                {
                    item = menu.findItem(R.id.icono);
                    item.setIcon(R.drawable.chat);
                }
                if (s.equals("mitab3"))
                {
                    item = menu.findItem(R.id.icono);
                    item.setIcon(R.drawable.contactos);
                }
            }
        });
        String [] llamadas = new String[] {"Llamada1"};
        String [] chats = new String[] {"Chat1"};
        String [] contactos = new String[] {"Contacto1"};
        ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,llamadas);
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,chats);
        ArrayAdapter<String> adaptador3 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contactos);
        listView1 = (ListView) findViewById(R.id.listView1);
        listView2 = (ListView) findViewById(R.id.listView2);
        listView3 = (ListView) findViewById(R.id.listView3);
        listView1.setAdapter(adaptador1);
        listView2.setAdapter(adaptador2);
        listView3.setAdapter(adaptador3);
    }
    public boolean onCreateOptionsMenu (Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu=menu;
        return true;
    }

}
