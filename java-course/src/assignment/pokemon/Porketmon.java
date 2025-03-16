package assignment.pokemon;

// 2025년 3월 14일 16:00 박성규 튜터님 캠핑장 객체 강의
// https://slowlove.notion.site/1b6dc9668e7780aa801af0e039a41a6c
public class Porketmon {
	private String name; // 포켓몬의 이름 (예: 피카츄)
	private String type; // 포켓몬의 타입 (예: 전기)
	private int hp; // 포켓몬의 체력 (예: 100)
	private int attack; // 공격력 (예: 20)
	private int defense; // 방어력 (예: 10)

	public Porketmon(String name, String type, int hp, int attack, int defense) {
		this.name = name;
		this.type = type;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	// 대상 포켓몬 공격
	public void attack(Porketmon targetPokemon) {
		System.out.println(this.name + "가 " + targetPokemon.getName() + "를 공격했습니다.");
		targetPokemon.takeDamage(this.attack);
	}

	// 포켓몬 피해 발생
	public boolean takeDamage(Integer amount) {
		this.hp -= amount;
		// System.out.println(this.name + "가 " + amount + "의 피해를 입었습니다.");
		// System.out.println(this.name + "의 hp는 " + this.hp + "입니다.");
		if(this.hp <= 0) {
			System.out.println(this.name + "가 쓰러졌습니다.");
			return true;
		}
		return false;
	}

	// 정보 조회
	public void printInfo() {
		System.out.println(name + " | 타입: " + type + " | 체력: " + hp + " | 공격력: " + attack + " | 방어력: " + defense);
	}
}
