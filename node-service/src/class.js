const mongoose=require('mongoose');
const Schema=mongoose.Schema;
const classSchema=new Schema({
    name:{type:"string",required:true},
    floor:{type:"number",required:true},
    number:{type:"number",required:true},
    type:{type:"string",required:true},
    description:{type:"string",required:true},
}
,{timestamps:true}
);
const Classes=mongoose.model('Classes',classSchema);
module.exports=Classes;