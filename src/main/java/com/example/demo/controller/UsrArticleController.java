package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.ArticleService;
import com.example.demo.util.Ut;
import com.example.demo.vo.Article;
import com.example.demo.vo.ResultData;

@Controller
public class UsrArticleController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public ResultData doModify(int id, String title, String body) {

		if(Ut.isEmptyOrNull(title)) {
			return ResultData.from("F-1", Ut.f("%d번 제목 입력해", id));
		}
		if(Ut.isEmptyOrNull(body)) {
			return ResultData.from("F-2", Ut.f("%d번 내용 입력해", id));
		}
			
		ResultData modifyArticleRd = articleService.modifyArticle(id,title, body);


		return ResultData.from(modifyArticleRd.getResultCode(), modifyArticleRd.getMsg(),id);
	}

	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public ResultData getArticle(int id) {

		Article article = articleService.getArticleById(id);

		if (article == null) {
			return ResultData.from("F-1", Ut.f("%d번 게시글은 없습니다", id));
		}

		return ResultData.from("S-1", Ut.f("%d번 게시글입니다", id), article);
	}

	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public ResultData doDelete(int id) {



		if (Ut.isEmpty(id)) {
			return ResultData.from("F-1", "해당 글이 없습니다.");
		}
		
		ResultData deleteArticleRd = articleService.deleteArticle(id);

		return ResultData.from(deleteArticleRd.getResultCode(), deleteArticleRd.getMsg(), id);
		
	}

	@RequestMapping("/usr/article/doWrite")
	@ResponseBody
	public ResultData doWrite(String title, String body) {

		if (Ut.isEmptyOrNull(title)) {
			return ResultData.from("F-1", "제목을 입력하세요");
		}

		if (Ut.isEmptyOrNull(body)) {
			return ResultData.from("F-2", "내용을 입력하세요");
		}

		ResultData writeArticleRd = articleService.writeArticle(title, body);
		

		int id = (int) writeArticleRd.getData1();

		Article article = articleService.getArticleById(id);

		return ResultData.from(writeArticleRd.getResultCode(), writeArticleRd.getMsg(), article);
	}

	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public ResultData getArticles() {
		List<Article> articles = articleService.getArticles();
		return ResultData.from("S-1", "Article List", articles);
	}
}