 Vue.component("fenye",{
		template:`<div class="row pageFen" v-if="pageTotal>1">
			<ul class="pagination pagination-sm offset-sm-4">
				<li class="page-item"><a class="page-link"    style="width:50px" @click="toPage(1)">首 页</a></li> 
				<li class="page-item"><a class="page-link"   @click="prePage"> « </a></li>	
				<li v-for="n in pageTotal"  :class="['page-item',(n==currentPage&&currentPage <4)? 'active' :  ((pageTotal-currentPage)>1 && pageTotal>5 && currentPage >3 && n==3)? 'active' : ((pageTotal-currentPage)<2 && pageTotal>5 && currentPage >3 && n==4 && (pageTotal!=currentPage) )? 'active' : ((pageTotal==currentPage) && n==5)? 'active': n>5? 'hid' :'' ]"  >
						<a class="page-link" @click="toPage(n)" v-if="pageTotal<6">{{n}}</a> 
						<a class="page-link" @click="toPage(n)"  v-if="pageTotal>5 && currentPage <4 && n<6">{{n}}</a> 
						<a class="page-link" @click="toPage(currentPage+(n-3))" v-if="(pageTotal-currentPage)>1 && pageTotal>5 && currentPage >3 && n<6">{{currentPage+(n-3)}}</a>
						<a class="page-link" @click="toPage(pageTotal+(n-5))"     v-if="(pageTotal-currentPage)<2 && pageTotal>5 && currentPage >3 && n<6">{{pageTotal+(n-5)}}</a>
				</li>
				<li class="page-item"><a class="page-link"   @click="nextPage" > » </a></li>
					<li class="page-item" ><a class="page-link"  style="width:50px"  @click="toPage(pageTotal) ">尾页</a></li>
			</ul>
			<div class="linkwid">到第 <input type="text"  class="myinnput  pos" v-model="sheet"/> 页 <button class="linkwid  btn btn-outline-primary mybtnprimary" @click="toPage(sheet)" >确定</button> <span class="linkwid " >共{{pageTotal}} 页</span>  <select  class="linkwid" style="outline:none"  v-model="pageSize" @change="changePageSize"><option value="5" >5 条/页</option><option value="10">10 条/页</option><option value="20">20 条/页</option><option value="50">50 条/页</option><option value="100">100 条/页</option></select></div>
		</div>`,
		props:["parentmsg"],		//子组件属性props接收绑定的自定义属性 [只读]
		data(){     
			return {		  
			        // 总页数
			        
			        pageNum:1,
			        // 每页显示的个数
			        pageSize:5,
			        // 当前页
			        cur:1,
			        currentPage:1,
			        // 总数据
			        totalPage:[],
			        // 当前显示的数据
			        dataShow:[],
					sheet:1,
					pageTotal: 2,
					all:[],
					requestParam:{  }
			 
		}
	},
	mounted(){
		this.synQueryData();
	},
	
	methods:{
		synQueryData(){
			axios({
				method: 'post',
				url: this.parentmsg,
				data: {
					msg:this.requestParam
				},
			}).then(res => {
				  this.all = res.data.list;
				  this.changePageSize();
			}, error => {
				console.log(error);
			})
		},
		condition(param){
			//alert("==="+param.appName)
			this.requestParam = param;
			this.	synQueryData();
		},

		changePageSize(){
			//重新计算页数
			var vm = this;
		      vm.pageNum = Math.ceil(this.all.length / vm.pageSize) || 1 ;
		      
		      for (var i = 1; i<=vm.pageNum; i++) {
		          vm.totalPage[i] = this.all.slice(vm.pageSize * (i-1), vm.pageSize * i)
		      }
		      this.pageTotal=vm.pageNum;
		
		      this.toPage(1);
		},
		nextPage(){
            var vm = this;
            if (vm.currentPage == vm.pageNum) return;
            vm.dataShow = vm.totalPage[++vm.currentPage]   ;
            this.pageTotal=vm.pageNum;
            this.cur = vm.currentPage;
            this.$emit('myfunc',vm.dataShow)
        },
        prePage(){
            var vm = this;
            if (vm.currentPage == 1) return;
            vm.dataShow = vm.totalPage[--vm.currentPage];
            this.cur = vm.currentPage;
            this.$emit('myfunc',vm.dataShow)
        },
        toPage(page){
            var vm = this;
            vm.currentPage = (page-1+1);
            if(page>vm.pageTotal){
            	ams_alert("老铁，一共才"+vm.pageTotal+"页!");
            	return;
            }
            vm.dataShow = vm.totalPage[vm.currentPage];
            this.cur = vm.currentPage;
            this.$emit('myfunc', vm.dataShow);
        },
 
		shouye(url){
			window.open(url,"_blank");
		}
	}

	})