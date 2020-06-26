/* 班课管理*/
const Classtmanage = () => import('@/pages/classManage')
//const ClassStudentmanage = () => import('@/pages/classManage/classStudentmanage')
//const Checkmanage = () => import('@/pages/classManage/checkManage')
const Viewclasslist = () => import('@/pages/classManage/viewClasslist')
const Workmanage = () => import('@/pages/classManage/workManage')
/* 角色管理 */
const designRolemanage = () => import('@/pages/Design-role-manage')
const designRolemanage1 = () => import('@/pages/Design-role-manage/Design-role-manage1')
/* 管理员管理*/
const administrator = () => import('@/pages/administrator')
const administratorManagement = () => import('@/pages/administrator/administratorManagement')
/* 用户管理*/
const Usermanage = () => import('@/pages/user-manage')
const Usermanagetest = () => import('@/pages/user-manage/user-manage-test')
/* 按钮管理*/
const Buttonmanagement = () => import('@/pages/buttonManagement')
const Buttonmanage = () => import('@/pages/buttonManagement/buttonManage')
/* 权限信息管理 */
const Perminssioninformanage = () => import('@/pages/permissionInformanage')
const Perminssionlist = () => import('@/pages/permissionInformanage/permissionList')
/* 数据字典*/
const Datadictionary = () => import('@/pages/dataDictionary')
const Datamanage = () => import('@/pages/dataDictionary/dataManage')
const Typemanage = () => import('@/pages/dataDictionary/typeManage')
/* 菜单管理 */
const Menumanage = () => import('@/pages/menuManage')
const Menu = () => import('@/pages/menuManage/menu')
/* 需要权限判断的路由 */
const dynamicRoutes = [
    {
        path:'/administrator',
        component:administrator,
        name:'administrator',
        meta: {
            name: '管理员管理',
            icon: 'user'
        },
        children: [
            {
                path: 'administratorManagement',
                name: 'administratorManagement',
                component: administratorManagement,
                meta: {
                    name: '管理员管理',
                    icon: 'table'
                }
            },
        ]
    },
    {
        path:'/Datadictionary',
        component:Datadictionary,
        name:'dataDictionary',
        meta: {
            name: '数据字典',
            icon: 'user'
        },
        children: [
            {
                path: 'Typemanage',
                name: 'typeManage',
                component: Typemanage,
                meta: {
                    name: '类型管理',
                    icon: 'table'
                }
            },
            {
                path: 'Datamanage',
                name: 'dataManage',
                component: Datamanage,
                meta: {
                    name: '数据管理',
                    icon: 'table'
                }
            }
        ]
    },
    {
        path:'/Menumanage',
        component:Menumanage,
        name:'menumanage',
        meta: {
            name: '菜单管理',
            icon: 'user'
        },
        children: [
            {
                path: 'Menu',
                name: 'menu',
                component: Menu,
                meta: {
                    name: '菜单管理',
                    icon: 'table'
                }
            },
        ]
    },
    {
        path:'/Usermanage',
        component:Usermanage,
        name:'user-manage',
        meta: {
            name: '用户管理',
            icon: 'user'
        },
        children: [
            {
                path: 'Usermanagetest',
                name: 'user-manage-test',
                component: Usermanagetest,
                meta: {
                    name: '用户管理',
                    icon: 'table'
                }
            },
        ]
    },
    {
        path:'/Perminssioninformanage',
        component:Perminssioninformanage,
        name:'Perminssioninformanage',
        meta: {
            name: '权限信息管理',
            icon: 'user'
        },
        children: [
            {
                path: 'Perminssionlist',
                name: 'Perminssionlist',
                component: Perminssionlist,
                meta: {
                    name: '权限信息列表',
                    icon: 'table'
                }
            },

        ]
    },
    {
        path:'/Buttonmanagement',
        component:Buttonmanagement,
        name:'Buttonmanagement',
        meta: {
            name: '参数设置',
            icon: 'user'
        },
        children: [
            {
                path: 'Buttonmanage',
                name: 'Buttonmanage',
                component: Buttonmanage,
                meta: {
                    name: '参数设置',
                    icon: 'table'
                }
            },

        ]
    },
    {
        path:'/Classtmanage',
        component:Classtmanage,
        name:'classManage',
        meta: {
            name: '班课管理',
            icon: 'user'
        },
        children: [
            //{
            //    path: 'ClassStudentmanage',
            //    name: 'classStudentmanage',
             //   component: ClassStudentmanage,
             //   meta: {
             //       name: '班课学生管理',
             //       icon: 'table'
             //   }
           // },
           // {
           //     path: 'Checkmanage',
             //   name: 'Checkmanage',
             //   component: Checkmanage,
            //    meta: {
            //        name: '签到管理',
             //       icon: 'table'
             //   }
           // },
            {
                path:'Viewclasslist',
                name:'Viewclasslist',
                component:Viewclasslist,
                meta:{
                    name:'管理员班课管理',
                    icon:'table'
                }
            },
            {
                path:'Workmanage',
                name:'Workmanage',
                component:Workmanage,
                meta:{
                    name:'教师班课管理',
                    icon:'table'
                }
            }

        ]
    },


      {
          path:'/designRolemanage',
          component:designRolemanage,
         name:'Design-role-manage',
          meta: {
              name: '角色管理',
             icon: 'user'
          },
         children: [
            {
                path: 'designRolemanage1',
                name: 'role-manage',
                 component: designRolemanage1,
               meta: {
                     name: '角色管理',
                   icon: 'table'
                 }
           },
              {
            }
        ]
     },
]

export default dynamicRoutes
