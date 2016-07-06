package cn.itcast.oa.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;

public class HqlHelperTest {

	/**
	 * 0 表示全部主题 <br>
	 * 1 表示只看精华帖
	 */
	private int viewType = 1;

	/**
	 * 0 代表默认排序(所有置顶帖在前面，并按最后更新时间降序排列)<br>
	 * 1 代表只按最后更新时间排序<br>
	 * 2 代表只按主题发表时间排序<br>
	 * 3 代表只按回复数量排序
	 */
	private int orderBy = 0;

	/**
	 * true 表示升序<br>
	 * false 表示降序
	 */
	private boolean asc = false;

	private Forum forum = new Forum();

	@Test
	public void testHqlHelper() {
		HqlHelper hqlHelper = new HqlHelper(Topic.class, "t")//
				.addCondition("t.forum=?", forum)//
				.addCondition(viewType == 1, "t.type=?", Topic.TYPE_BEST) // 1表示只看精华帖
				.addOrder(orderBy == 1, "t.lastUpdateTime", asc) // 1 代表只按最后更新时间排序
				.addOrder(orderBy == 2, "t.postTime", asc) // 2 代表只按主题发表时间排序
				.addOrder(orderBy == 3, "t.replyCount", asc) // 3 代表只按回复数量排序
				.addOrder(orderBy == 0, "(CASE t.type WHEN 2 THEN 2 ELSE 0 END)", false)//
				.addOrder(orderBy == 0, "t.lastUpdateTime", false) // 0 代表默认排序(所有置顶帖在前面，并按最后更新时间降序排列)
		;

		System.out.println(hqlHelper.getQueryListHql());
		System.out.println(hqlHelper.getQueryCountHql());
		System.out.println(hqlHelper.getParameters());

	}
}
