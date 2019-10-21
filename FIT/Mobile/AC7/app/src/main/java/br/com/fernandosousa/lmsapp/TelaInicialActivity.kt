package br.com.fernandosousa.lmsapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.widget.*

class TelaInicialActivity : DebugActivity() {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tela_inicial)

        val args = intent.extras

        val nome = args.getString("nome")

        val numero = intent.getIntExtra("nome",0)

        Toast.makeText(context, "Parâmetro: $nome", Toast.LENGTH_LONG).show()
        Toast.makeText(context, "Numero: $numero", Toast.LENGTH_LONG).show()

        val mensagem = findViewById<TextView>(R.id.lblRelacaoClientes)
        mensagem.text = "Bem vindo $nome"

        val botaoSair = findViewById<Button>(R.id.botaoSair)
        botaoSair.setOnClickListener {cliqueSair()}

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val lvClientes = findViewById<ListView>(R.id.lvClientes)

        val listaClientes = ArrayList<String>()
        listaClientes.add("João vitor Paulino martins")
        listaClientes.add("Tiago beneteli")
        listaClientes.add("Daniel rodrigues")
        listaClientes.add("Ramon cavalcante pires")
        listaClientes.add("Maria ferreia da silva")
        listaClientes.add("Angélica de souza vieira")
        listaClientes.add("Nádila haddad")
        listaClientes.add("Vanessa de jesus")
        listaClientes.add("Gilberto barros ferreira de souza")
        listaClientes.add("Cainã")
        listaClientes.add("talita guimarães")

        val adapter = ArrayAdapter<String>(context, R.layout.list_item , R.id.txtNomeCliente, listaClientes)

        lvClientes.adapter = adapter

        supportActionBar?.title = "Clientes"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun cliqueSair() {

        val returnIntent = Intent()

        returnIntent.putExtra("result","Saída do Estética cláudia Rossini")

        setResult(Activity.RESULT_OK,returnIntent)

        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView)
                .setOnQueryTextListener(
                        object : SearchView.OnQueryTextListener {

                            override fun onQueryTextChange(newText: String): Boolean {
                                // ação enquanto está digitando
                                return false
                            }

                            override fun onQueryTextSubmit(query: String): Boolean {
                                // ação  quando terminou de buscar e enviou
                                return false
                            }

                        }
                )

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        when (id) {
            R.id.action_buscar -> Toast.makeText(context, "Botão de buscar", Toast.LENGTH_LONG).show()

            R.id.action_atualizar -> Toast.makeText(context, "Botão de atualizar", Toast.LENGTH_LONG).show()

            R.id.action_config -> Toast.makeText(context, "Botão de configuracoes", Toast.LENGTH_LONG).show()

            android.R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)
    }

}
