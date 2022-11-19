const router = require("express").Router();
const {getAllClasses,addClass,deleteClass,updateClass,getClassByName,getClassByFloor}=require('./controller');
router.get('/',getAllClasses);
router.post('/',addClass);
router.delete('/:id',deleteClass);
router.put('/:id',updateClass);
router.get('/name/:name',getClassByName);
router.get('/floor/:floor',getClassByFloor);
module.exports=router;
