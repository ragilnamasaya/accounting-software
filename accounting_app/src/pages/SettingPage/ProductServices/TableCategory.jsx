import React, { useState } from 'react'

function TableCategory(props) {

   var initialCategory = {
      name: ""
   }

   const [addCategory, setAddCategory] = useState(initialCategory)
   const changeValue = (e) => {
      var { name, value } = e.target
      setAddCategory({ ...addCategory, [name]: value })
   }
   const addCategoryHandler = () => {
      console.log('====================================');
      console.log(addCategory);
      console.log('====================================');
      props.add(addCategory)
      setOpen(false)
      setAddCategory(initialCategory)
   }

   const [open, setOpen] = useState(false)

   const openForm = () => {
      setOpen(true)
   }
 

   const [currentId, setCurrentId] = useState("")

   const editHandler = (id, idx) => { 
      setCurrentId(id)
      setOpen(true)
      var initialCategory = {
         name: props.data[idx].name
      }
      setAddCategory(initialCategory)

   }

   const deleteHandler = (id) => { 
      props.delete(id)
   }

   const updateHandler = (e) => { 
      e.preventDefault()
      props.edit(currentId, addCategory)
      setOpen(false)
      setAddCategory(initialCategory)
   }

   const closeForm = () => {
      setOpen(false)
      setCurrentId("")
      setAddCategory(initialCategory)
   }

   const [q, setQ] = useState("")

   function search(rows) { 
     return rows.filter(row => row.name.toLowerCase().indexOf(q) > -1);
   }


   return (
      <>
         

         {open ? <>
            <div className="col-lg-12 row d-flex justify-content-between  my-3">
               <div className="col-lg-6">
                  <input type="text" className="form-control" name="name" value={addCategory.name} placeholder="Category Name" onChange={changeValue} />
               </div>
               <div className="col-lg-6 row">
                  {currentId !== "" ? <>
                  <input type="button" className="btn mr-3 button btn-success" value="Update" onClick={updateHandler} />
                  </> : <>
                  <input type="button" className="btn mr-3  button btn-success" value="Add +" onClick={addCategoryHandler} />
                     </>}
                     <input type="button" className="btn  button btn-danger" value="Cancel" onClick={closeForm} />
               </div>
            </div>
         </> :
            <>
               <div className="col-lg-12 d-flex justify-content-between my-3">
                  <div className="col-lg-6">
                  <input type="button" className="btn btn-primary button" onClick={openForm} value="Add Category +"/>
                  </div>
                  <div className="col-lg-6">
                     <input type="text" className="form-control" placeholder="seacrh" value={q} onChange={(e)=>setQ(e.target.value)}/>
                  </div>
            </div>
            </>}
         <table className="table" style={{ minWidth: "500px", maxHeight: "700px", overflow: "auto" }}>
            <tr>
               <th>Category Name</th>
               <th>Product QTY</th>
               <th>Action</th>
            </tr>
            {props.data.length === 0 ?
               <>
                  <tr>
                     <td colSpan="3" className="text-center">  No Data Record..</td>

                  </tr>
               </>
               :
               <>
                  {search(props.data).map((data, idx) =>
                     <tr key={data.id}>
                        <td>{data.name}</td>
                        <td>{data.count_product}</td>
                        <td>
                           <button className="btn btn-link button" onClick={()=>editHandler(data.id,idx)}><i className="fas fa-pencil-alt"></i>
                           </button>
                           <button className="btn btn-link button" onClick={()=>deleteHandler(data.id)}><i className="fas fa-trash"></i>
                           </button>
                        </td>
                     </tr>
                  )}
               </>}
         </table>

      </>
   )
}



export default TableCategory
