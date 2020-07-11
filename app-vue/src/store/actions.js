import axios from '@/request/index.js'
import api from '@/api/index.js'
const actions = {
  /**
  * @description: 物种列表页面
  * @author:caoxh
  * @date: 2020/07/11/ 21：23
  * */
  SpeciesList({commit},options) {
    return new Promise((resolve, reject) => {
      axios.post(api.SpeciesList_POST, options).then(res => {
        resolve(res.data)
      }).catch(e => {
        reject(e)
      })
    })
  },
  /**
  * @description: 物种搜索页面
  * @author:caoxh
  * @date: 2020/07/11/ 21：29
  * */
  SpeciesSearch({commit},options) {
  return new Promise((resolve, reject) => {
    axios.post(api.SpeciesSearch_POST, options).then(res => {
      resolve(res.data)
    }).catch(e => {
      reject(e)
    })
  })
}
}
export default actions
