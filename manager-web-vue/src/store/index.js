import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
    state: {
        // 左侧菜单栏数据
        menuItems: [
            {
                name: 'home', // 要跳转的路由名称 不是路径
                size: 18, // icon大小
                type: 'md-home', // icon类型
                text: '主页' // 文本内容
            },
            {
                text: '物种管理',
                type: 'ios-paper',
                children: [
                    {
                        type: 'ios-grid',
                        name: 'lifeCategoryList',
                        text: '物种列表'
                    }
                ]
            }
        ],
        dialogVisible: true
    },
    mutations: {
        setMenus(state, items) {
            state.menuItems = [...items]
        },
        setDialogVisible(state, visible) {
            state.dialogVisible = visible
        }
    },
    getters: {
        getDialogVisible(state) {
            return state.dialogVisible
        }
    }
})

export default store
