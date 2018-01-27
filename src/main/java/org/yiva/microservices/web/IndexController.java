package org.yiva.microservices.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.yiva.microservices.model.Jounal;

@RestController
@RequestMapping("/")
public class IndexController {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value= {"/","index"})
	public String index() {
		String sql = "select id,ac_category,ac_date,ac_type,ac_type_name,ac_content,ac_price,ac_operater,ac_channel,ac_save_style,ac_poudage,ac_comment,ac_rewarder,ac_rewarder_name,ac_student,ac_student_name,create_time,update_time from db_cqt.t_jounal";
		try {
			RowMapper<Jounal> rowMapper = new BeanPropertyRowMapper<Jounal>(
					Jounal.class);
			ArrayList<Jounal> list = (ArrayList<Jounal>) jdbcTemplate
					.query(sql, rowMapper);
			return list.get(0).getAc_content();
		} catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping("queryList")
	public ArrayList<Jounal> queryDate() {
		String sql = "select id,ac_category,ac_date,ac_type,ac_type_name,ac_content,ac_price,ac_operater,ac_channel,ac_save_style,ac_poudage,ac_comment,ac_rewarder,ac_rewarder_name,ac_student,ac_student_name,create_time,update_time from db_cqt.t_jounal";
		try {
			RowMapper<Jounal> rowMapper = new BeanPropertyRowMapper<Jounal>(
					Jounal.class);
			ArrayList<Jounal> list = (ArrayList<Jounal>) jdbcTemplate
					.query(sql, rowMapper);
			return list;
		} catch (Exception e) {
			return null;
		}
	}
}
