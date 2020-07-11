import axios from "axios";
// axios.defaults.withCredentials = true;
/**
 * http 请求工具
 * 
 * 请求拦截器  负责奖客户端标识token值存储并放置在头部提交给服务端
 * 
 * 响应拦截器  负责全局处理业务请求的网络或者业务错误
 * */
// let session = Cookies.get('SESSION')
// 添加cookie值为session
// if(session != undefined){
//     document.cookie = session 
// }else{
//     session = Cookies.get('SESSION')
//     console.log(' no session')
// }
//创建axios的实例化
const service = axios.create({
    baseURL: process.env.VUE_APP_BASE_URL,
    timeout: 30000,// 请求超时时间
    })
// 请求拦截
service.interceptors.request.use(
    (config) => {
        return config
    },
    (error) => {
        return Promise.reject(error)
    }
    )
// 响应拦截器
service.interceptors.response.use(
    (response) => {
        return response
    },
    (error) => {
        return Promise.reject(error)
    }
    )
    export default service
