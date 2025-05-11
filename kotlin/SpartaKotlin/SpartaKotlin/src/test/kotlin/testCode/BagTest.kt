package testCode 
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.shouldBe
import java.lang.Exception

class BagTest : BehaviorSpec({
    Given("a valid max weight") {
        val validMaxWeight = 10

        When("execute constructor") {
            val result = Bag(validMaxWeight)

            Then("max weight should be valid max weight") {
                result.maxWeight shouldBe validMaxWeight
            }
        }
    }

    Given("a max weight = 0") {
        val maxWeight = 0

        When("execute constructor") {
            val exception = shouldThrow<Exception> { Bag(maxWeight) }

            Then("exception message should be expected") {
                exception.message shouldBe "가방의 최대 무게가 잘못 설정되었습니다."
            }
        }
    }

    Given("a max weight is negative") {
        val maxWeight = -10

        When("execute constructor") {
            val exception = shouldThrow<Exception> { Bag(maxWeight) }

            Then("exception message should be expected") {
                exception.message shouldBe "가방의 최대 무게가 잘못 설정되었습니다."
            }
        }
    }

    // putItem
    Given("a Bag and a Item") {
        val bag = Bag(100)
        val item = Item("고양이", 6)

        When("execute putItem") {
            bag.putItem(item)

            Then("item is in itemList of bag") {
                bag.itemList.size shouldBe 1
                bag.itemList.first() shouldBe item
            }
        }
    }

    Given("a Bag and a too heavy item") {
        val bag = Bag(10)
        val item = Item("고양이", 60)

        When("execute putItem") {
            val exception = shouldThrow<Exception> { bag.putItem(item) }

            Then("exception message should be expected") {
                exception.message shouldBe "가방에 아이템을 넣을 수 없습니다."
            }
        }
    }

    // removeItem
    Given("a Bag has a Item") {
        val bag = Bag(100)
        val item = Item("고양이", 6)
        bag.putItem(item)

        When("execute putItem") {
            bag.removeItem(item)

            Then("item is not in itemList of bag") {
                bag.itemList.size shouldBe 0
            }
        }
    }

    Given("a Bag has many Items") {
        val bag = Bag(100)
        val item1 = Item("고양이", 6)
        val item2 = Item("사료", 20)
        val items = listOf(item1, item2,
            Item("물", 20),
        )
        items.forEach(bag::putItem)

        When("execute putItem") {
            val targetItem = items[1]
            bag.removeItem(targetItem)

            Then("item is not in itemList of bag") {
                bag.itemList.size shouldBe items.size - 1
                bag.itemList shouldNotContain targetItem
            }
        }
    }

    Given("a Bag without Item") {
        val bag = Bag(100)

        When("execute putItem") {
            val targetItem = Item("고양이", 6 )
            bag.removeItem(targetItem)

            Then("item is not in itemList of bag") {
                bag.itemList.size shouldBe 0
                bag.itemList shouldNotContain targetItem
            }
        }
    }
})
