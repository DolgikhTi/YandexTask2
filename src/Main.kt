fun main() {
    val n = readLine()!!.toInt() // Чтение длины строки
    val s = readLine()!! // Чтение строки

    val dp = IntArray(n + 1) { Int.MAX_VALUE } // Массив для динамического программирования
    dp[0] = 0 // Базовый случай: пустая строка

    for (i in 1..n) {
        val count = mutableMapOf<Char, Int>() // Счетчик символов в текущей подстроке
        var maxCount = 0 // Максимальное количество вхождений символа

        for (j in i downTo 1) {
            val char = s[j - 1]
            count[char] = count.getOrDefault(char, 0) + 1
            maxCount = maxOf(maxCount, count[char]!!)

            // Проверяем условие: есть ли символ, который встречается более чем в половине позиций
            if (maxCount > (i - j + 1) / 2) {
                if (dp[j - 1] != Int.MAX_VALUE) {
                    dp[i] = minOf(dp[i], dp[j - 1] + 1)
                }
            }
        }
    }

    println(dp[n]) // Выводим результат
}