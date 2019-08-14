<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	<link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/main.css">
	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	table tbody tr:nth-child(odd){background:#F4F4F4;}
	table tbody td:nth-child(even){color:#C00;}
	</style>
  </head>

  <body>
<!-- <div style="z-index:-1"> -->
	<%@ include file="/WEB-INF/jsp/commons/top.jsp"  %>
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
			<div class="tree">
				<ul style="padding-left:0px;" class="list-group">
					<li class="list-group-item tree-closed" >
						<a href="main.html"><i class="glyphicon glyphicon-dashboard"></i> 控制面板</a> 
					</li>
					<li class="list-group-item">
						<span><i class="glyphicon glyphicon glyphicon-tasks"></i> 权限管理 <span class="badge" style="float:right">3</span></span> 
						<ul style="margin-top:10px;">
							<li style="height:30px;">
								<a href="${APP_PATH }/user/toIndex.do" style="color:red;"><i class="glyphicon glyphicon-user"></i> 用户维护</a> 
							</li>
							<li style="height:30px;">
								<a href="role.html"><i class="glyphicon glyphicon-king"></i> 角色维护</a> 
							</li>
							<li style="height:30px;">
								<a href="permission.html"><i class="glyphicon glyphicon-lock"></i> 许可维护</a> 
							</li>
						</ul>
					</li>
					<li class="list-group-item tree-closed">
						<span><i class="glyphicon glyphicon-ok"></i> 业务审核 <span class="badge" style="float:right">3</span></span> 
						<ul style="margin-top:10px;display:none;">
							<li style="height:30px;">
								<a href="auth_cert.html"><i class="glyphicon glyphicon-check"></i> 实名认证审核</a> 
							</li>
							<li style="height:30px;">
								<a href="auth_adv.html"><i class="glyphicon glyphicon-check"></i> 广告审核</a> 
							</li>
							<li style="height:30px;">
								<a href="auth_project.html"><i class="glyphicon glyphicon-check"></i> 项目审核</a> 
							</li>
						</ul>
					</li>
					<li class="list-group-item tree-closed">
						<span><i class="glyphicon glyphicon-th-large"></i> 业务管理 <span class="badge" style="float:right">7</span></span> 
						<ul style="margin-top:10px;display:none;">
							<li style="height:30px;">
								<a href="cert.html"><i class="glyphicon glyphicon-picture"></i> 资质维护</a> 
							</li>
							<li style="height:30px;">
								<a href="type.html"><i class="glyphicon glyphicon-equalizer"></i> 分类管理</a> 
							</li>
							<li style="height:30px;">
								<a href="process.html"><i class="glyphicon glyphicon-random"></i> 流程管理</a> 
							</li>
							<li style="height:30px;">
								<a href="advertisement.html"><i class="glyphicon glyphicon-hdd"></i> 广告管理</a> 
							</li>
							<li style="height:30px;">
								<a href="message.html"><i class="glyphicon glyphicon-comment"></i> 消息模板</a> 
							</li>
							<li style="height:30px;">
								<a href="project_type.html"><i class="glyphicon glyphicon-list"></i> 项目分类</a> 
							</li>
							<li style="height:30px;">
								<a href="tag.html"><i class="glyphicon glyphicon-tags"></i> 项目标签</a> 
							</li>
						</ul>
					</li>
					<li class="list-group-item tree-closed" >
						<a href="param.html"><i class="glyphicon glyphicon-list-alt"></i> 参数管理</a> 
					</li>
				</ul>
			</div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="panel panel-default">
			  <div class="panel-heading">
				<h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
			  </div>
			  <div class="panel-body">
<form class="form-inline" role="form" style="float:left;">
  <div class="form-group has-feedback">
    <div class="input-group">
      <div class="input-group-addon">查询条件</div>
      <input id="queryText" class="form-control has-success" type="text" placeholder="请输入查询条件">
    </div>
  </div>
  <button id="queryBtn" type="button" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
</form>
<button type="button" class="btn btn-danger" style="float:right;margin-left:10px;" onclick="deleteBatchBtn()"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
<button type="button" class="btn btn-primary" style="float:right;" onclick="window.location.href='${APP_PATH}/user/toAdd.htm'"><i class="glyphicon glyphicon-plus"></i> 新增</button>
<br>
 <hr style="clear:both;">
          <div class="table-responsive">
            <table class="table  table-bordered">
              <thead>
                <tr >
                  <th width="30">#</th>
				  <th width="30"><input id="allCheckBox" type="checkbox"></th>
                  <th>账号</th>
                  <th>名称</th>
                  <th>邮箱地址</th>
                  <th width="100">操作</th>
                </tr>
              </thead>
              <tbody>


              </tbody>
			  <tfoot>
			     <tr >
				     <td colspan="6" align="center">
						 <ul class="pagination">

						</ul> 
					 </td>
				 </tr>

			  </tfoot>
            </table>
          </div>
			  </div>
			</div>
        </div>
      </div>
    </div>
<!-- </div > -->
	<div id="panel-modify" style="width:100%;height:100%;background-color:rgba(176,176,176,0.5);display:none;position:absolute;left:0px;top:0px;padding:20%;z-index:1001">
		<form id="modifyForm" style="background-color:rgba(176,176,176,1);width:50%;height:50%;position:absolute;left:25%;top:25%;padding:35px;padding-top:3px;padding-bottom:3px;">
			<button id="closeBtn" type="button" class="btn "style="background-color:rgba(176,176,176,0);position:relative;left:95%;"><i class="glyphicon glyphicon-remove"></i></button>
			<div class="form-group">
				<label for="floginacct">登陆账号</label>
				<input type="text" class="form-control" id="floginacct" placeholder="请输入登陆账号">
			</div>
			<div class="form-group">
				<label for="fusername">用户名称</label>
				<input type="text" class="form-control" id="fusername"  placeholder="请输入用户名称">
			</div>
			<div class="form-group">
				<label for="femail">邮箱地址</label>
				<input type="email" class="form-control" id="femail"  placeholder="请输入邮箱地址">
				<p class="help-block label label-warning">请输入合法的邮箱地址, 格式为： xxxx@xxxx.com</p>
			</div>
			<button id="submitBtn" type="button" class="btn "><i class="glyphicon glyphicon-plus"></i> 提交</button>
			<button id="resetBtn" type="button" class="btn "><i class="glyphicon glyphicon-refresh"></i>重置</button>
		</form>
	</div>
	
    <script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/script/docs.min.js"></script>
	<script src="${APP_PATH}/jquery/layer/layer.js"></script>
        <script type="text/javascript">
            $(function () {
			    $(".list-group-item").click(function(){
				    if ( $(this).find("ul") ) {
						$(this).toggleClass("tree-closed");
						if ( $(this).hasClass("tree-closed") ) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});
			    queryPageUser(1);
            });
            $("tbody .btn-success").click(function(){
                window.location.href = "assignRole.html";
            });
            $("tbody .btn-primary").click(function(){
                window.location.href = "edit.html";
            });
            function pageChange(pageno){
//             	window.location.href = "${APP_PATH }/user/index.do?pageno="+pageno;//同步
            	queryPageUser(pageno);
            }
            
            var jsonObj ={
    			"pageno":1,
    			"pagesize":10
    		};
            var loadingIndex = -1;
            function queryPageUser(pageno){
            	jsonObj.pageno = pageno;
            	$.ajax({
            		type:"POST",
            		data:jsonObj,
            		url:"${APP_PATH}/user/index.do",
            		beforeSend:function(){
            			loadingIndex = layer.load(2,{time:10*1000});
            			return true;
            		},
            		success:function(result){
            			layer.close(loadingIndex);
            			if(result.success){
            				var page = result.page; 
            				var data = page.datas;

//             				layer.msg("返回结果: "+data,{time:1000,icon:0,shift:6})
// 							$("tbody").html(""+data);
							var content = '';
							$.each(data,function(i,n){
								content+='<tr>';
								content+='	 <td>'+(i+1)+'</td>';
								content+='	 <td><input type="checkbox" id="'+n.id+'"></td>';
								content+='	 <td>'+n.loginacct+'</td>';
								content+='	 <td>'+n.username+'</td>';
								content+='	 <td>'+n.email+'</td>';
								content+='	 <td>';
								content+='		 <button type="button" class="btn btn-success btn-xs" ><i class=" glyphicon glyphicon-check"></i></button>';
								content+='		 <button type="button" class="btn btn-primary btn-xs" onclick="modifyUser('+n.id+')"><i class=" glyphicon glyphicon-pencil"></i></button>';
								content+='		 <button type="button" class="btn btn-danger btn-xs" onclick="deleteUser('+n.id+',\''+n.loginacct+'\')"><i class=" glyphicon glyphicon-remove"></i></button>';
								content+='	 </td>';
								content+='</tr>';
							});
							$("tbody").html(content);
							
							var contentBar = '';
							if(page.pageno == 1){
								contentBar+='<li class="disabled"><a href="#">上一页</a></li>';
							}else{
								contentBar+='<li ><a onclick="pageChange('+(page.pageno-1)+')">上一页</a></li>';
							};
							for(var i = 1;i<=page.totalno;i++){
								contentBar+='<li'
								if(page.pageno == i){
									contentBar+=' class="active"';
								}
								contentBar+='><a  onclick="pageChange('+i+')">'+i+'</a></li>';
								
							}
							if(page.pageno == page.totalno	){
								contentBar+='<li class="disabled"><a href="#">下一页</a></li>';
							}else{
								contentBar+='<li ><a onclick="pageChange('+(page.pageno+1)+')">下一页</a></li>';
							};	
							
							$(".pagination").html(contentBar);
							layer.msg("数据加载成功",{time:1000,icon:0,shift:6});
            			}else{
            				layer.msg(result.message,{time:1000,icon:0,shift:6});
            			}
            		},
            		error:function(){
            			layer.msg("加载失败",{time:1000,icon:0,shift:6});
            		}
            	});
            };
            
            $("#queryBtn").click(function(){
            		var queryText = $("#queryText").val();
            		jsonObj.queryText = queryText;
//             		layer.msg(""+jsonObj);
            		queryPageUser(1);
            });	
           
           function modifyUser(id){
        	   jsonObj.id=id;
                $.ajax({
            		type:"POST",
            		data:{
            			"id":id
            		},
            		url:"${APP_PATH}/user/queryUser.do?ld=1",
            		beforeSend:function(){
            			loadingIndex = layer.load(1,{time:10*1000});
            			return true;
            		},
            		success:function(result){
            			layer.close(loadingIndex);
            			if(result.success){	
            				var data = result.pojo; 
								$("#floginacct").val(data.loginacct);
								$("#fusername").val(data.username);
								$("#femail").val(data.email);
							
            			}else{
            				layer.msg(result.message,{time:1000,icon:0,shift:6});
            			}
            		},
            		error:function(){
            			layer.msg("加载失败",{time:1000,icon:0,shift:6});
            		}
            	});
        	   $("#panel-modify")[0].style.display="block";
           };
           $("#submitBtn").click(function(){
        	   layer.confirm("确定要修改吗？",{icon:3,title:'提示'},function(cindex){ 
        	   $.ajax({
      			  type:"POST",
      			  data:{
      				  "id":jsonObj.id,
      				  "loginacct":$("#floginacct").val(),
      				  "username":$("#fusername").val(),
      				  "email":$("#femail").val()
      			  },
      			  url:"${APP_PATH}/user/modifyUser.do",
      			  beforeSend:function(){
      				 loadingIndex = layer.load(2,{time:10*1000});
      				  return true;
      			  },
      			  success:function(result){
      				layer.close(loadingIndex);
      				  if(result.success){
      		        	   $("#panel-modify")[0].style.display="none";
      		        	   
      		        	   layer.msg(result.message,{time:1000,icon:0,shift:6});
      		        	   
      		        	   queryPageUser(1);
      				  }else{
      					   layer.msg(result.message,{time:1000,icon:0,shift:6});
      				  }
      			  },
 	     		  error:function(){
 	         			layer.msg("修改失败",{time:1000,icon:0,shift:6});
 	         	  }
      			  
      		   });
    		   layer.close(cindex);
        	   },function(cindex){
        		   layer.close(cindex);
        	   });
           });
           $("#closeBtn").click(function(){
        	   $("#panel-modify")[0].style.display="none";
           });
           $("#resetBtn").click(function(){
           	   $("#modifyForm")[0].reset();
           });
           
           function deleteUser(id,loginacct){
        	   layer.confirm("确定要删除 ["+loginacct+"]用户吗？",{icon:3,title:'提示'},function(cindex){
        		   $.ajax({
   					type:"POST",
   					data:{
   						"id":id
   					},
   					url:"${APP_PATH}/user/deleteUser.do",
   					beforeSend:function(){
   						loadingIndex = layer.load(2,{time:10*1000});
   						return true;
   					},
   					success:function(result){
   						layer.close(loadingIndex);
   						if(result.success){
   							
   							layer.msg(result.message,{time:1000,icon:0,shift:6});
   							queryPageUser(1);
   						}else{
   							layer.msg(result.message,{time:1000,icon:0,shift:6});
   						}
   					},
   					error:function(){
   						layer.msg("修改失败",{time:1000,icon:0,shift:6});
   					}
   				});
        		
        		   layer.close(cindex);
        	   },function(cindex){
        		   layer.close(cindex);
        	   });	  
           };
           $("#allCheckBox").click(function(){
        	   var checkBoxStatus=this.checked;
//         	   attr设置属性值会出现bug
        	   $("tbody tr td input[type='checkbox']").prop("checked",checkBoxStatus);
           });
           function deleteBatchBtn(){
        	   var selectCheckbox = $("tbody tr td input:checked");
        	   var arrayId=new Array();
        	   
        	   $.each(selectCheckbox,function(i,n){
        		   arrayId[i]=n.id;
        	   });
        	   layer.confirm("确定要删除吗？",{icon:3,title:'提示'},function(cindex){
        		   $.ajax({
   					type:"POST",
   					data:{
   						"arrayId":arrayId
   					},
   					traditional: true,
   					url:"${APP_PATH}/user/deleteBatchUser.do",
   					beforeSend:function(){
   						
   						if(selectCheckbox.length>0){
   							loadingIndex = layer.load(2,{time:10*1000});
   							return true;
   						}else{
   							layer.msg("请勾选至少一个用户",{time:1000,icon:0,shift:6});
   							return false;
   						}
   						
   						
   					},
   					success:function(result){
   						layer.close(loadingIndex);
   						if(result.success){
   							
   							layer.msg(result.message,{time:1000,icon:0,shift:6});
   							queryPageUser(1);
   						}else{
   							layer.msg(result.message,{time:1000,icon:0,shift:6});
   						}
   					},
   					error:function(){
   						layer.msg("修改失败",{time:1000,icon:0,shift:6});
   					}
   				});
        		
        		   layer.close(cindex);
        	   },function(cindex){
        		   layer.close(cindex);
        	   });	  
           };
        </script>
  </body>
</html>
