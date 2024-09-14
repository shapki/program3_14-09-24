fun main() {
    // Имеется массив из символов русского алфавита (все 33 символа, могут быть не по порядку). Символы алфавита нумеруются от 1 до 33. Каждое число используется только один раз.  Сообщение шифруется с помощью ключевого слова, задаваемого пользователем. Номер символа ключевого слова показывает, на сколько нужно сдвинуться по массиву из символов русского алфавита. Составить программу шифровки и дешифровки строкового выражения (то есть программа спрашивает - зашифровать или расшифровать текст и ключевое слово). Первый массив считать закольцованным. Регистр букв не имеет значения. Например:
    // А	Б	В	Г	Д	Е	Ё	Ж	З	И	Й	К	Л	М	Н	О	П	Р	С	Т	У	Ф	Х	Ц	Ч	Ш	Щ	Ь	Ы	Ъ	Э	Ю	Я
    // 21	13	4	20	22	1	25	12	24	14	2	28	9	23	3	29	6	16	15	11	26	5	30	27	8	18	10	33	31	32	19	7	17
    // Ключевое слово - ПОЛЕ
    // Исходный текст - СООБЩЕНИЕ
    // Зашифрованный текст - АЁФИРХЖСЮ

    val alphabet = charArrayOf('А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ь','Ы','Ъ','Э','Ю','Я')
    val numbers = intArrayOf( 21, 13, 4, 20, 22, 1, 25, 12, 24, 14, 2, 28, 9, 23, 3, 29, 6, 16, 15, 11, 26, 5, 30, 27, 8, 18, 10, 33, 31, 32, 19, 7, 17 )

    println("Действие: 1 - шифр, 2 - дешифр")
    val action = readln().toInt()

    println("Ключевое слово:")
    val keyword = readln()

    println("Текст:")
    val text = readln()

    val result = if (action == 1) {
        encrypt(text, keyword, alphabet, numbers)
    } else if (action == 2) {
        decrypt(text, keyword, alphabet, numbers)
    } else {
        "Некорректное действие."
    }

    println("Результат: $result")
}

fun encrypt(text: String, keyword: String, alphabet: CharArray, numbers: IntArray): String {
    var result = ""
    var temp = 0

    for(char in text){
        if(char in alphabet){
            val chId = alphabet.indexOf(char)
            val shift = numbers[keyword[temp % keyword.length].toInt() - 'А'.toInt()]
            val newId = (chId + shift) % alphabet.size
            result += alphabet[newId]
            temp++
        } else {
            result += char
        }
    }

    return result
}

fun decrypt(text: String, keyword: String, alphabet: CharArray, numbers: IntArray): String {
    var result = ""
    var temp = 0

    for(char in text) {
        if(char in alphabet) {
            val chId = alphabet.indexOf(char)
            val shift = numbers[keyword[temp % keyword.length].toInt() - 'А'.toInt()]
            val newId = (chId - shift + alphabet.size) % alphabet.size
            result += alphabet[newId]
            temp++
        } else {
            result += char
        }
    }

    return result
}
