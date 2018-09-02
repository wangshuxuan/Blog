<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="data_list">
    <div class="data_list_title">
        <img src="${pageContext.request.contextPath}/static/images/list_icon.png"/>&nbsp;最新博客
    </div>
    <div class="datas">
        <ul>
            <c:forEach items="${pageInfo.list}" var="blog">
                <li style="margin-bottom: 30px">
					  	<span class="title">
					  		<img alt="文章类型" src="${pageContext.request.contextPath}/static/userImages/yuan.jpg">
					  		<a href="${pageContext.request.contextPath}/blog/articles/${blog.id}">${blog.title }</a>
					  	</span>
                    <span class="summary">摘要: ${blog.summary }....</span>
                    <span class="img">
					  		<c:forEach items="${blog.imageList }" var="image">
                                <a href="${pageContext.request.contextPath}/blog/articles/${blog.id}.html">${image }</a>
                                &nbsp;&nbsp;
                            </c:forEach>
	
					  	</span>
                    <span class="info">
					  		<font color="#999"><fmt:formatDate value="${blog.releaseDate }" type="date"
                                                               pattern="yyyy-MM-dd HH:mm"/></font> &nbsp;&nbsp;
					  		<font color="#33a5ba"><a
                                    href="${pageContext.request.contextPath}/blog/articles/${blog.id}.html">阅读</a><font
                                    color="#999">(${blog.clickHit })</font>&nbsp;&nbsp;</font>
					  		<font color="#33a5ba"><a
                                    href="${pageContext.request.contextPath}/blog/articles/${blog.id}.html">评论</a><font
                                    color="#999">(${blog.replyHit })</font>&nbsp;&nbsp;</font>
					  	</span>
                </li>
                <hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:10px;"/>
            </c:forEach>
        </ul>
    </div>

    <div style="text-align: center;">
        <div class="row">
            <div class="col-md-6">当前${pageInfo.pageNum }页,总${pageInfo.pages }页，总${pageInfo.total }条记录</div>
            <div class="col-md-6">
                <ul class="pagination">
                    <li><a href="${pageContext.request.contextPath}/index.do">首页</a></li>
                    <!--如果有前一页则加上前一页的超链接  -->
                    <c:if test="${pageInfo.hasPreviousPage }">
                        <li><a href="${pageContext.request.contextPath}/index.do?page=${pageInfo.pageNum-1}"
                               aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                        </a></li>
                    </c:if>
                    <!--循环遍历所有页码并显示 -->
                    <c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
                        <c:if test="${page_Num==pageInfo.pageNum }">
                            <li class="active"><a href="#">${page_Num}</a></li>
                        </c:if>

                        <c:if test="${page_Num!=pageInfo.pageNum }">
                            <li><a href="${pageContext.request.contextPath}/index.do?page=${page_Num}">${page_Num}</a></li>
                        </c:if>


                    </c:forEach>
                    <!--如果有下一页则显示下一页的超级链接 -->
                    <c:if test="${pageInfo.hasNextPage }">
                        <li><a href="${pageContext.request.contextPath}/index.do?page=${pageInfo.pageNum+1}" aria-label="Next"><span
                                aria-hidden="true">&raquo;</span></a></li>
                    </c:if>

                    <li><a href="${pageContext.request.contextPath}/index.do?page=${pageInfo.pages}">末页</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

