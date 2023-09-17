// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario (val nome: String, val sobrenome: String, val idade: Number) {

    override fun toString() = "Usuario(${nome}, ${sobrenome}, ${idade})"

}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel) {

    override fun toString() = "ConteudoEducacional(${nome}, ${duracao}, ${nivel})"
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.add(usuario)
    }

    fun showInscritos() {
        println(inscritos.toString())
    }
}

fun printGenericMutableList (genericList: MutableList<*>) {
    for (i in 0 until genericList.size) {
        println(genericList[i].toString())
    }
}

fun <T: Any> addGeneric (genericList: MutableList<T>, singleUnit: T) {
    genericList.add(singleUnit)
}

fun createUsuario(listaUsuario: MutableList<Usuario>) {
    println("Digite o nome do 'Usuario': ")
    val nome: String = readLine()!!
    println("Digite o sobrenome do 'Usuario': ")
    val sobrenome: String = readLine()!!
    println("Digite a idade do 'Usuario': ")
    val idade: Number = readLine()!!.toInt()

    val newUsuario = Usuario(nome, sobrenome, idade)

    addGeneric(listaUsuario, newUsuario)
}

fun createConteudoEducacional(listaConteudoEducacional: MutableList<ConteudoEducacional>) {
    println("Digite o nome do 'ConteudoEducacional': ")
    val nome: String = readLine()!!
    println("Digite a duracao do 'ConteudoEducacional': ")
    val duracao: Number = readLine()!!.toInt()
    println("Digite o nivel do 'ConteudoEducacional': ")
    val nivel: String = readLine()!!
    var nivelEnum: Nivel = Nivel.BASICO

    if (nivel == "basico") { nivelEnum = Nivel.BASICO }
    if (nivel == "intermediario") { nivelEnum = Nivel.INTERMEDIARIO }
    if (nivel == "dificil") { nivelEnum = Nivel.DIFICIL }

    val newConteudoEducacional = ConteudoEducacional(nome, duracao as Int, nivelEnum)
    addGeneric(listaConteudoEducacional, newConteudoEducacional)
}

fun createListConteudoEducacionalFormacao (
    listaConteudoEducacional: MutableList<ConteudoEducacional>): MutableList<ConteudoEducacional> {
    var newListaConteudoEducacional = mutableListOf<ConteudoEducacional>()
    var gate = 0
    try {
        while (gate > -1) {
            println("Enter the id of the 'ConteudoEducacional':")
            println("Enter -1 to quit. ")
            val line = readLine()
            if (line != null) {
                gate = line.toInt()
                val selectedConteudoEducation: ConteudoEducacional = listaConteudoEducacional[gate]
                if (selectedConteudoEducation != null) {
                    newListaConteudoEducacional.add(selectedConteudoEducation)
                }
            }
        }
    } catch (exception: Exception) {
        println("Exited.")
    }

    return newListaConteudoEducacional
}

fun createFormacao(tempListaConteudoEducacional: MutableList<ConteudoEducacional>, listaFormacao: MutableList<Formacao>) {
    println("Digite o nome da 'Formacao': ")
    val nome: String = readLine()!!

    val newFormacao = Formacao(nome, tempListaConteudoEducacional)
    addGeneric(listaFormacao, newFormacao)

}

fun createMatricula(listaUsuario: MutableList<Usuario>, listaFormacao: MutableList<Formacao>) {
    try {
        println("Enter the id of the 'Usuario':")
        val usuarioId = readLine()
        println("Enter the id of the 'Formacao':")
        val formacaoId = readLine()
        val selectedUsuario = listaUsuario[usuarioId?.toInt()!!]
        val selectedFormacao = listaFormacao[formacaoId?.toInt()!!]
        selectedFormacao.matricular(selectedUsuario)
    } catch (exception: Exception) {
        println("Wrong id, try again.")
    }
}

fun showInscritosByFormacao(listaFormacao: MutableList<Formacao>) {
    try {
        println("Enter the id of the 'Formacao':")
        val formacaoId = readLine()
        val selectedFormacao = listaFormacao[formacaoId?.toInt()!!]
        selectedFormacao.showInscritos()
    } catch (exception: Exception) {
        println("Wrong id, try again.")
    }
}

fun main() {
    val listaUsuario = mutableListOf<Usuario>()
    val listaConteudoEducacional = mutableListOf<ConteudoEducacional>()
    var tempListaConteudoEducacional = mutableListOf<ConteudoEducacional>()
    val listaFormacao = mutableListOf<Formacao>()

    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    var gate = 1
    while (gate > 0) {
        println("Enter 1 to create a 'ConteudoEducacional': ")
        println("Enter 2 to show all 'ConteudoEducacional':")
        println("Enter 3 to create a new list of 'ConteudoEducacional' to use with a 'Formacao': ")
        println("Enter 4 to show the temp list of 'ConteudoEducacional' to use with a 'Formacao': ")
        println("Enter 5 to create a 'Formacao':")
        println("Enter 6 to show all 'Formacao':")
        println("Enter 7 to create a 'Usuario': ")
        println("Enter 8 to show all 'Usuario':")
        println("Enter 9 to create 'Matricula':")
        println("Enter 10 to show all 'Inscritos' with a 'Formacao':")
        println("Enter 0 to quit. ")
        val line = readLine()
        if (line != null) {
            gate = line.toInt()
            when (gate) {
                1 -> createConteudoEducacional(listaConteudoEducacional)
                2 -> printGenericMutableList(listaConteudoEducacional)
                3 -> tempListaConteudoEducacional = createListConteudoEducacionalFormacao(listaConteudoEducacional)
                4 -> printGenericMutableList(tempListaConteudoEducacional)
                5 -> createFormacao(tempListaConteudoEducacional, listaFormacao)
                6 -> printGenericMutableList(listaFormacao)
                7 -> createUsuario(listaUsuario)
                8 -> printGenericMutableList(listaUsuario)
                9 -> createMatricula(listaUsuario, listaFormacao)
                10 -> showInscritosByFormacao(listaFormacao)
            }
        } else {
            println("No values given.")
            gate = 0
        }
    }
}