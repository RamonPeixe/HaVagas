package br.edu.ifsp.scl.ads.havagas

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nomeCompletoEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var receberAtualizacoesCb: CheckBox
    private lateinit var telefoneEt: EditText
    private lateinit var tipoTelefoneRg: RadioGroup
    private lateinit var celularEt: EditText
    private lateinit var sexoRg: RadioGroup
    private lateinit var dataNascimentoEt: EditText
    private lateinit var formacaoSp: Spinner
    private lateinit var formacaoCamposLl: LinearLayout
    private lateinit var anoFormaturaEt: EditText
    private lateinit var anoConclusaoEt: EditText
    private lateinit var instituicaoEt: EditText
    private lateinit var tituloMonografiaEt: EditText
    private lateinit var orientadorEt: EditText
    private lateinit var vagasInteresseEt: EditText
    private lateinit var salvarBt: Button
    private lateinit var limparBt: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nomeCompletoEt = findViewById(R.id.nomeCompletoEt)
        emailEt = findViewById(R.id.emailEt)
        receberAtualizacoesCb = findViewById(R.id.receberAtualizacoesCb)
        telefoneEt = findViewById(R.id.telefoneEt)
        tipoTelefoneRg = findViewById(R.id.tipoTelefoneRg)
        celularEt = findViewById(R.id.celularEt)
        sexoRg = findViewById(R.id.sexoRg)
        dataNascimentoEt = findViewById(R.id.dataNascimentoEt)
        formacaoSp = findViewById(R.id.formacaoSp)
        formacaoCamposLl = findViewById(R.id.formacaoCamposLl)
        anoFormaturaEt = findViewById(R.id.anoFormaturaEt)
        anoConclusaoEt = findViewById(R.id.anoConclusaoEt)
        instituicaoEt = findViewById(R.id.instituicaoEt)
        tituloMonografiaEt = findViewById(R.id.tituloMonografiaEt)
        orientadorEt = findViewById(R.id.orientadorEt)
        vagasInteresseEt = findViewById(R.id.vagasInteresseEt)
        salvarBt = findViewById(R.id.salvarBt)
        limparBt = findViewById(R.id.limparBt)

        formacaoSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                updateFormacaoFields(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        tipoTelefoneRg.setOnCheckedChangeListener { _, checkedId ->
            celularEt.visibility = if (checkedId == R.id.comercialRb) View.GONE else View.VISIBLE
        }

        salvarBt.setOnClickListener {
            showDetails()
        }

        limparBt.setOnClickListener {
            clearFields()
        }
    }

    private fun updateFormacaoFields(position: Int) {
        when (position) {
            0, 1 -> {
                anoFormaturaEt.visibility = View.VISIBLE
                anoConclusaoEt.visibility = View.GONE
                instituicaoEt.visibility = View.GONE
                tituloMonografiaEt.visibility = View.GONE
                orientadorEt.visibility = View.GONE
            }
            2, 3 -> {
                anoFormaturaEt.visibility = View.GONE
                anoConclusaoEt.visibility = View.VISIBLE
                instituicaoEt.visibility = View.VISIBLE
                tituloMonografiaEt.visibility = View.GONE
                orientadorEt.visibility = View.GONE
            }
            4, 5 -> {
                anoFormaturaEt.visibility = View.GONE
                anoConclusaoEt.visibility = View.VISIBLE
                instituicaoEt.visibility = View.VISIBLE
                tituloMonografiaEt.visibility = View.VISIBLE
                orientadorEt.visibility = View.VISIBLE
            }
        }
    }

    private fun showDetails() {
        val nome = nomeCompletoEt.text.toString()
        val email = emailEt.text.toString()
        val receberAtualizacoes = receberAtualizacoesCb.isChecked
        val telefone = telefoneEt.text.toString()
        val tipoTelefone = findViewById<RadioButton>(tipoTelefoneRg.checkedRadioButtonId).text
        val celular = celularEt.text.toString()
        val sexo = findViewById<RadioButton>(sexoRg.checkedRadioButtonId).text
        val dataNascimento = dataNascimentoEt.text.toString()
        val formacao = formacaoSp.selectedItem.toString()
        val anoFormatura = anoFormaturaEt.text.toString()
        val anoConclusao = anoConclusaoEt.text.toString()
        val instituicao = instituicaoEt.text.toString()
        val tituloMonografia = tituloMonografiaEt.text.toString()
        val orientador = orientadorEt.text.toString()
        val vagasInteresse = vagasInteresseEt.text.toString()

        val details = """
            Nome: $nome
            E-mail: $email
            Receber Atualizações: $receberAtualizacoes
            Telefone: $telefone ($tipoTelefone)
            Celular: $celular
            Sexo: $sexo
            Data de Nascimento: $dataNascimento
            Formação: $formacao
            Ano de Formatura: $anoFormatura
            Ano de Conclusão: $anoConclusao
            Instituição: $instituicao
            Título da Monografia: $tituloMonografia
            Orientador: $orientador
            Vagas de Interesse: $vagasInteresse
        """.trimIndent()

        Toast.makeText(this, details, Toast.LENGTH_LONG).show()
    }

    private fun clearFields() {
        nomeCompletoEt.text.clear()
        emailEt.text.clear()
        receberAtualizacoesCb.isChecked = false
        telefoneEt.text.clear()
        tipoTelefoneRg.clearCheck()
        celularEt.text.clear()
        sexoRg.clearCheck()
        dataNascimentoEt.text.clear()
        formacaoSp.setSelection(0)
        anoFormaturaEt.text.clear()
        anoConclusaoEt.text.clear()
        instituicaoEt.text.clear()
        tituloMonografiaEt.text.clear()
        orientadorEt.text.clear()
        vagasInteresseEt.text.clear()
    }
}
