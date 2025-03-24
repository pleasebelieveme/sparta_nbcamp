package assignment.pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
https://slowlove.notion.site/1b6dc9668e7780aa801af0e039a41a6c
 */
public class Main {
	public static void main(String[] args) {

		Porketmon pica = new Porketmon("피카츄", "전기", 100, 20, 10);
		Porketmon pairi = new Porketmon("파이리", "불꽃", 90, 25, 8);
		Porketmon kkobugi = new Porketmon("꼬부기", "물", 110, 18, 12);
		
		/*
		[출력 예시]
		피카츄가 파이리를 공격합니다!
		파이리의 남은 체력은 73입니다.

		피카츄가 파이리를 공격합니다!
		파이리의 남은 체력은 46입니다.

		파이리가 쓰러졌습니다.
		 */
		List<Porketmon> pokemonList = new ArrayList<>();

		pokemonList.add(pica);
		pokemonList.add(pairi);
		pokemonList.add(kkobugi);


		while (pairi.getHp() > 0) {
			pica.attack(pairi);
		}

		List<Porketmon> porketmonBattleList = new ArrayList<>();
		porketmonBattleList.add(pica);
		porketmonBattleList.add(pairi);

		System.out.println("==========================");
		pica.printInfo();
		pairi.printInfo();
	}
}
