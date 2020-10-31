package programmers.wintercoding;

public class sql {
	/*
	SELECT T.name_x, T.name_y, count(*)
	FROM(SELECT distinct c1.cart_id as cart_id, c1.name as name_x, c2.name as name_y
	     from cart_products c1, cart_products c2
	     where c1.cart_id = c2.cart_id and c1.name != c2.name
	     ) T
	group by T.name_x, T.name_y
	order by T.name_x, T.name_y
	*/
}
