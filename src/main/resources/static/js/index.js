function toggleClass(index){
	  		var hh='hh'+index;
	  		var jj='jj'+index;
	  	
	  		
			var cur=$('#'+hh).hasClass('icon-wenjianjia') ? 'icon-wenjianjia' : 'icon-ic_folder';
			//全部设置成默认格式：文件闭合，箭头向下
	  		$('.hh').removeClass('icon-ic_folder');
	  		$('.jj').removeClass('icon-shangjiantou');
	  		$('.hh').addClass('icon-wenjianjia');
	  		$('.jj').addClass('icon-xiajiantou');
	  		//完毕
			if(cur=='icon-wenjianjia'){
				$('#'+hh).removeClass(cur);
				$('#'+jj).removeClass('icon-xiajiantou');
				$('#'+hh).addClass('icon-ic_folder');
				$('#'+jj).addClass('icon-shangjiantou');
			}
			else{
				$('#'+hh).removeClass(cur);
				$('#'+jj).removeClass('icon-shangjiantou');
				$('#'+hh).addClass('icon-wenjianjia');
				$('#'+jj).addClass('icon-xiajiantou');
			}         
  }

function cal(index){
	toggleClass(index);
}
function href(myhref){
	ifra.location.href=myhref;
}

