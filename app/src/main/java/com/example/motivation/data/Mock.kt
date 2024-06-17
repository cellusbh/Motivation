package com.example.motivation.data

import com.example.motivation.infra.MotivationConstants

class Phrase(val description: String, val categoryId: Int, val language: String)

class Mock {

    private val all = MotivationConstants.FILTER.ALL
    private val auto = MotivationConstants.FILTER.AUTO
    private val android = MotivationConstants.FILTER.ANDROID
    private val langEn = MotivationConstants.LANGUAGE.ENGLISH
    private val langPt = MotivationConstants.LANGUAGE.PORTUGUESE
    private val langFr = MotivationConstants.LANGUAGE.FRENCH

    private val listPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", auto, langPt),
        Phrase(
            "Você não é derrotado quando perde, você é derrotado quando desiste!",
            auto,
            langPt
        ),
        Phrase("Quando está mais escuro, vemos mais estrelas!", auto, langPt),
        Phrase(
            "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.",
            auto,
            langPt
        ),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", auto, langPt),
        Phrase(
            "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?",
            auto,
            langPt
        ),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", android, langPt),
        Phrase("Você perde todas as chances que você não aproveita.", android, langPt),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", android, langPt),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", android, langPt),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", android, langPt),
        Phrase("Se você acredita, faz toda a diferença.", android, langPt),
        Phrase(
            "Riscos devem ser corridos, porque o maior perigo é não arriscar nada!",
            android,
            langPt
        ),
        Phrase("Not knowing it was impossible, he went there and did it.", auto, langEn),
        Phrase(
            "You are not defeated when you lose, you are defeated when you give up!",
            auto,
            langEn
        ),
        Phrase("When it's darker, we see more stars!", auto, langEn),
        Phrase(
            "Insanity is always doing the same thing and expecting a different result.",
            auto,
            langEn
        ),
        Phrase("Don't stop when you're tired, stop when you're done.", auto, langEn),
        Phrase("What can you do now that has the biggest impact on your success?", auto, langEn),
        Phrase("The best way to predict the future is to invent it.", android, langEn),
        Phrase("You lose every chance you don't take.", android, langEn),
        Phrase("Failure is the spice that flavors success.", android, langEn),
        Phrase(" As long as we are not committed, there will be hesitation!", android, langEn),
        Phrase("If you don't know where you want to go, any way will do.", android, langEn),
        Phrase("If you believe, it makes all the difference.", android, langEn),
        Phrase(
            "Risks must be taken, because the greatest danger is not risking anything!",
            android,
            langEn
        ),
        Phrase("Ne sachant pas que c'était impossible, il y est allé et l'a fait.", auto, langFr),
        Phrase(
            "Tu n'es pas vaincu quand tu perds, tu es vaincu quand tu abandonnes!",
            auto,
            langFr
        ),
        Phrase("Quand il fait plus sombre, on voit plus d'étoiles!", auto, langFr),
        Phrase(
            "La folie, c'est toujours faire la même chose et s'attendre à un résultat différent.",
            auto,
            langFr
        ),
        Phrase("Ne t'arrête pas quand tu es fatigué, arrête quand tu as fini.", auto, langFr),
        Phrase(
            "Que pouvez-vous faire maintenant qui a le plus grand impact sur votre succès?",
            auto,
            langFr
        ),
        Phrase("La meilleure façon de prédire l'avenir est de l'inventer.", android, langFr),
        Phrase("Vous perdez toutes les chances que vous ne prenez pas.", android, langFr),
        Phrase("L'échec est l'épice qui parfume le succès.", android, langFr),
        Phrase("Tant qu'on n'est pas engagé, il y aura des hésitations!", android, langFr),
        Phrase(
            "Si vous ne savez pas où vous voulez aller, n'importe quoi fera l'affaire.",
            android,
            langFr
        ),
        Phrase("Si vous croyez, cela fait toute la différence.", android, langFr),
        Phrase(
            "Il faut prendre des risques, car le plus grand danger est de ne rien risquer!",
            android,
            langFr
        )
    )

    fun getPhrase(value: Int, language: String): String {
        var langFilter = language.lowercase()
        if (language !in listOf(langEn, langPt, langFr)) {
            langFilter = langPt
        }
        val filtered =
            listPhrases.filter { (it.categoryId == value || value == all) && (it.language == langFilter) }
        val random = java.util.Random().nextInt(filtered.size)
        return filtered[random].description
    }

}