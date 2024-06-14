package com.example.motivation.data

import com.example.motivation.infra.MotivationConstants

class Phrase(val description: String, val categoryId: Int)

class Mock {

    private val all = MotivationConstants.FILTER.ALL
    private val auto = MotivationConstants.FILTER.AUTO
    private val android = MotivationConstants.FILTER.ANDROID

    private val listPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", auto),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", auto),
        Phrase("Quando está mais escuro, vemos mais estrelas!", auto),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", auto),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", auto),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", auto),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", android),
        Phrase("Você perde todas as chances que você não aproveita.", android),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", android),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", android),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", android),
        Phrase("Se você acredita, faz toda a diferença.", android),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", android)
    )

    fun getPhrase(value: Int): String {
        val filtered = listPhrases.filter { (it.categoryId == value || value == all) }
        val random = java.util.Random().nextInt(filtered.size)
        return filtered[random].description
    }

}