package com.example.android.recyclerview

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {


    var contactos:ArrayList<Contacto> = ArrayList()
    private lateinit var myLayoutManager : RecyclerView.LayoutManager
    private lateinit var myContactosAdapter: ContactoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        AddContactos()


        myLayoutManager = LinearLayoutManager(this)
        myContactosAdapter = ContactoListAdapter (contactos)


        rvListaContactos.apply {
            setHasFixedSize(true)
            layoutManager = myLayoutManager
            adapter = myContactosAdapter
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        }

    }

    private fun AddContactos() {
        contactos.add(Contacto("Alex Sanchez", "148723942"))
        contactos.add(Contacto("Alex Zazueta", "0987654321"))
        contactos.add(Contacto("Francisco Caballero", "18892343"))
        contactos.add(Contacto("Karina Rodríguez", "190939482"))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
