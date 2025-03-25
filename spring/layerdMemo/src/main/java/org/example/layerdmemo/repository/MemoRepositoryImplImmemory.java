// package org.example.layerdmemo.repository;
//
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
//
// import org.example.layerdmemo.dto.MemoResponseDto;
// import org.example.layerdmemo.entity.Memo;
// import org.springframework.stereotype.Repository;
//
// /**
//  * Annotation @Repository는 @Component와 같다, Spring Bean으로 등록한다는 뜻.
//  * Spring Bean으로 등록되면 다른 클래스에서 주입하여 사용할 수 있다.
//  * 명시적으로 Repository Layer 라는것을 나타낸다.
//  * DB와 상호작용하여 데이터를 CRUD하는 작업을 수행한다.
//  */
//
// @Repository // @Controller와 다른건 Repository를 component로 등록한다는 것 뿐이다.
// public class MemoRepositoryImplImmemory implements MemoRepository {
//
// 	private final Map<Long, Memo> memoList = new HashMap<>();
//
// 	@Override
// 	public Memo saveMemo(Memo memo) {
//
// 		// memo 식별자 자동 생성
// 		Long memoId = memoList.isEmpty() ? 1L : Collections.max(memoList.keySet()) + 1L;
// 		memo.setId(memoId);
//
// 		memoList.put(memoId, memo);
//
// 		return memo;
// 	}
//
// 	@Override
// 	public List<MemoResponseDto> findAllMemos() {
// 		// init List
// 		List<MemoResponseDto> allMemos = new ArrayList<>();
// 		for (Memo memo : memoList.values()) {
// 			MemoResponseDto responseDto = new MemoResponseDto(memo);
// 			allMemos.add(responseDto);
// 		}
// 		return allMemos;
// 	}
//
// 	@Override
// 	public Memo findMemoById(Long id) {
// 		return memoList.get(id);
// 	}
//
// 	@Override
// 	public void deleteMemo(Long id) {
// 		memoList.remove(id);
// 	}
// }