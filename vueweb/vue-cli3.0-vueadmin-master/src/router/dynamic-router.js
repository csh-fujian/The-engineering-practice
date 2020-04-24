/* 订单管理 */
const Order = () => import('@/pages/order-manage')
const OrderList = () => import('@/pages/order-manage/order-list')
const ProductManage = () => import('@/pages/order-manage/product-manage')
const ProductionList = () =>
    import('@/pages/order-manage/product-manage/production-list')
const ReviewManage = () =>
    import('@/pages/order-manage/product-manage/review-manage')
const ReturnGoods = () => import('@/pages/order-manage/return-goods')

/* 产品管理 */
const Goods = () => import('@/pages/goods-manage')
const GoodsList = () => import('@/pages/goods-manage/goods-list')
const GoodsClassify = () => import('@/pages/goods-manage/goods-classify')
// 权限管理
const Permission = () => import('@/pages/permission')
const UserManage = () => import('@/pages/permission/user-manage')
const RoleManage = () => import('@/pages/permission/role-manage')
const MenuManage = () => import('@/pages/permission/menu-manage')
//用户管理
const roleManageTest = () => import('@/pages/role-manageTest')
const ManageTest = () => import('@/pages/role-manageTest/manage')
//角色管理
const roleManage = () => import('@/pages/user-manage')
const roleManagetest = () => import('@/pages/user-manage/user-manage-test')
//设计角色管理Test
const designRolemanage = () => import('@/pages/Design-role-manage')
const designRolemanage1 = () => import('@/pages/Design-role-manage/Design-role-manage1')
/* 需要权限判断的路由 */
const dynamicRoutes = [
    {
        path: '/order',
        component: Order,
        name: 'order-manage',
        meta: {
            name: '数据字典',
            icon: 'example'
        },
        children: [
            {
                path: 'list',
                name: 'order-list',
                component: OrderList,
                meta: {
                    name: '字典类型管理',
                    icon: 'table'
                }
            },
            {
                path:'ReturnGoods',
                name:'return-goods',
                component:ReturnGoods,
                meta: {
                    name: '字典数据管理',
                    icon: 'table'
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
                name: 'Design-role-manage1',
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
    {
        path: '/goods',
        component: Goods,
        name: 'goods',
        meta: {
            name: '菜单管理',
            icon: 'user'
        },
        children: [
            {
                path: 'list',
                name: 'order-list',
                component: OrderList,
                meta: {
                    name: '菜单管理',
                    icon: 'table'
                }
            },
            {
            }
        ]
    },
    {
        path: '/goods',
        component: Goods,
        name: 'goods',
        meta: {
            name: '查看权限管理',
            icon: 'user'
        },
        children: [
            {
                path: 'list',
                name: 'goods-list',
                component: GoodsList,
                meta: {
                    name: '查看权限管理',
                    icon: 'table'
                }
            }
        ]
    },

    {
        path: '/permission',
        component: Permission,
        name: 'permission',
        meta: {
            name: '班课管理',
            icon: 'table'
        },
        children: [
            {
                path: 'user',
                name: 'user-manage',
                component: UserManage,
                meta: {
                    name: '查看班课列表',
                    icon: 'table'
                }
            },
            {
                path: 'role',
                name: 'role-manage',
                component: RoleManage,
                meta: {
                    name: '班课学生管理',
                    icon: 'eye'
                }
            },
            {
                path: 'menu',
                name: 'menu-manage',
                component: MenuManage,
                meta: {
                    name: '作业管理',
                    icon: 'tree'
                }
            },
            {
                path: 'list',
                name: 'order-list',
                component: OrderList,
                meta: {
                    name: '签到管理',
                    icon: 'table'
                }
            }
        ]
    },
    {
        path: '/role-manageTest',
        component: roleManageTest,
        name: 'role-manageTest',
        meta: {
            name: '角色管理',
            icon: 'table'
        },
        children: [
            {
                path: 'manage',
                name: 'manage',
                component: ManageTest,
                meta: {
                    name: '角色管理',
                    icon: 'table'
                }
            }
        ]
    }
]

export default dynamicRoutes
