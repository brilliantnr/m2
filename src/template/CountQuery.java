package template;

import java.sql.ResultSet;
import enums.MemberQuery;

public class CountQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("--CountQuery 진입 : "+MemberQuery.COUNT.toString());
		map.put("sql",MemberQuery.COUNT.toString());
	}

	@Override
	void startPlay() {
		/*try {
			pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
		} catch (Exception e) {e.printStackTrace();}*/
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			//rs.next() 반드시 사용해야한다 불린타입이므로 true,false 지정해야함
			number = (rs.next())? rs.getInt("count") : 0;
		} catch (Exception e) {e.printStackTrace();}
		
	}
}





/*
number=0;  //super.nubmer=0;
int number=0 지역변수선언, 해당 메소드 내에서만 가능

*/