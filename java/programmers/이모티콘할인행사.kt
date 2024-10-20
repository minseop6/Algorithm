class 이모티콘할인행사 {
    private val discountRates = listOf(0.1, 0.2, 0.3, 0.4)
    private var answer: MutableList<Pair<Int, Int>> = mutableListOf()

    fun solution(userArray: Array<IntArray>, emoticons: IntArray): IntArray {
        val users = userArray.map { user -> User(user[0], user[1]) }
        dfs(users, emoticons, 0)
        return answer
            .maxWithOrNull(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })!!
            .toList().toIntArray()
    }

    private fun dfs(users: List<User>, emoticonPrices: IntArray, emoticonIndex: Int) {
        if (emoticonIndex >= emoticonPrices.size) {
            val (emoticonPlusRegistrationCount, salePrice) = users.fold(0 to 0) { acc, user ->
                if (user.balance > 0) acc.first to (acc.second + user.spentMoney())
                else (acc.first + 1) to acc.second
            }
            answer.add(emoticonPlusRegistrationCount to salePrice)
            return
        }

        for (discountRate in discountRates) {
            val copiedUsers = users.map { user -> user.copy() }
            for (user in copiedUsers) {
                if (discountRate >= user.buyableRate) {
                    val emoticonPrice = emoticonPrices[emoticonIndex]
                    val discountPrice = emoticonPrice * discountRate
                    val discountedPrice = emoticonPrice - discountPrice
                    user.buy(discountedPrice.toInt())
                }
            }
            dfs(copiedUsers, emoticonPrices, emoticonIndex + 1)
        }
    }
}

data class User(
    val buyableRate: Double,
    val buyableMoney: Int,
    var balance: Int,
) {
    constructor(buyableRate: Int, buyableMoney: Int) : this(
        buyableRate = (buyableRate.toDouble() / 100),
        buyableMoney = buyableMoney,
        balance = buyableMoney
    )

    fun buy(emoticonPrice: Int) {
        this.balance -= emoticonPrice
    }

    fun spentMoney() = buyableMoney - balance
}
