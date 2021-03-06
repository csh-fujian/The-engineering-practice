import { fetchPermission } from '@/api/permission'
import axios from 'axios'
import router, { DynamicRoutes } from '@/router/index'
import { recursionRouter } from '@/utils/recursion-router'
import dynamicRouter from '@/router/dynamic-router'

export default {
    namespaced: true,
    state: {
        permissionList: null /** 所有路由 */,
        sidebarMenu: [] /** 导航菜单 */,
        currentMenu: '' /** 当前active导航菜单 */,
        control_list: [] /** 完整的权限列表 */,
        avatar: ''/** 头像 */,
        account: ''/** 用户角色 */
    },
    getters: {},
    mutations: {
        SET_AVATAR(state, avatar) {
            state.avatar = avatar
        },
        SET_ACCOUNT(state, account) {
            state.account = account
        },
        SET_PERMISSION(state, routes) {
            state.permissionList = routes
        },
        CLEAR_PERMISSION(state) {
            state.permissionList = null
        },
        SET_MENU(state, menu) {
            state.sidebarMenu = menu
        },
        CLEAR_MENU(state) {
            state.sidebarMenu = []
        },
        SET_CURRENT_MENU(state, currentMenu) {
            state.currentMenu = currentMenu
        },
        SET_CONTROL_LIST(state, list) {
            state.control_list = list
        }
    },
    actions: {
        async FETCH_PERMISSION({ commit, state }) {
			let getavatar
			let getname
			let rolelist
            // let permissionList = await fetchPermission()
            console.log("42")

            await axios.get("http://47.112.239.108:8080/webinitialization/parse",{
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                    Authorization: localStorage.getItem('token')
               }
            }).then(res => {
				console.log(res.data)
				console.log(res)
				getavatar = res.data.nickname
				getname = res.data.role
				if(res.data.role == "admin"){
					if(res.data.layer == '1'){
									rolelist = ['Design-role-manage1','Design-role-manage','user-manage-test','user-manage','administratorManagement','administrator','role-manage','menu','menumanage','dataDictionary','dataManage','typeManage','classManage','Viewclasslist','Checkmanage','Buttonmanagement','Buttonmanage','Perminssioninformanage','Perminssionlist']	
					}else{
							rolelist = ['Design-role-manage1','Design-role-manage','user-manage-test','user-manage','role-manage','menu','menumanage','dataDictionary','dataManage','typeManage','classManage','Viewclasslist','Checkmanage','Buttonmanagement','Buttonmanage','Perminssioninformanage','Perminssionlist']
					}

			
				}else{
				rolelist = ['classManage','Workmanage','classStudentmanage','Buttonmanagement','Buttonmanage']	
				}
            })
			
			console.log(getavatar)
			
            let permissionList = {
            avatar : getavatar,
            data : rolelist,
            name: getname,
            roles: [getname]
        }
		
        //    permissionList.data.push('Design-role-manage1')
        //     permissionList.data.push('Design-role-manage')
        //    permissionList.data.push('user-manage-test')
        //    permissionList.data.push('user-manage')
        //    permissionList.data.push('administratorManagement')
        //    permissionList.data.push('administrator')
        //    permissionList.data.push('role-manage')
        //    permissionList.data.push('menu')
         //   permissionList.data.push('menumanage')
         //   permissionList.data.push('dataDictionary')
        //    permissionList.data.push('dataManage')
        //    permissionList.data.push('typeManage')
        //     permissionList.data.push('classManage')

        //     permissionList.data.push('classStudentmanage')
        //    permissionList.data.push('Checkmanage')
        //      permissionList.data.push('Viewclasslist')
        //      permissionList.data.push('Workmanage')
        //     permissionList.data.push('Buttonmanagement')
        //    permissionList.data.push('Buttonmanage')
        //   permissionList.data.push('Perminssioninformanage')
        //     permissionList.data.push('Perminssionlist')


            commit('SET_AVATAR', permissionList.avatar)
            commit('SET_ACCOUNT', permissionList.avatar)
            let routes = recursionRouter(permissionList.data, dynamicRouter)
            let MainContainer = DynamicRoutes.find(v => v.path === '')
            let children = MainContainer.children
            commit('SET_CONTROL_LIST', [...children, ...dynamicRouter])
            children.push(...routes)
			console.log("323123123")
			console.log(children)
			console.log("323123123")
            commit('SET_MENU', children)
            let initialRoutes = router.options.routes
            router.addRoutes(DynamicRoutes)
            commit('SET_PERMISSION', [...initialRoutes, ...DynamicRoutes])
        }
    }
}
