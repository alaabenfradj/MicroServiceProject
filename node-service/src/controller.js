const Classes = require('./class');
const addClass= async (req,res)=>{
   try{
    const newClass=new Classes(req.body);
    newClass.save();
    return res.status(201).json(newClass)
}
catch(err){
    res.status(500).json({message:err.message})
}

}
// crud for class model with error message and status code mongoDB
const getAllClasses=async (req,res)=>{
    try{
        const classes=await Classes.find({}).lean().exec();
        if(classes.length===0){
            return res.status(204).json({message:"No classes found"})
        }
        return res.status(200).json(classes)
    }
    catch(err){
        res.status(500).json({message:err.message})
    }
}
const deleteClass=async (req,res)=>{
    try{
        const deletedClass=await Classes.findByIdAndDelete(req.params.id);
        if(!deletedClass){
            return res.status(404).json({message:"Class not found"})
        }
        return res.status(200).json(deletedClass)
    }
    catch(err){
        res.status(500).json({message:err.message})
    }
}
const updateClass=async (req,res)=>{
    try{
        const updatedClass=await Classes.findByIdAndUpdate(req.params.id,req.body,{new:true});
        if(!updatedClass){
            return res.status(404).json({message:"Class not found"})
        }
        return res.status(200).json(updatedClass)
    }
    catch(err){
        res.status(500).json({message:err.message})
    }
}
const getClassByName=async (req,res)=>{
    try{
        const classByName=await Classes.find({name:req.params.name});
        if(classByName.length===0){
            return res.status(204).json({message:"Class not found"})
        }
        return res.status(200).json(classByName)
    }
    catch(err){
        res.status(500).json({message:err.message})
    }
}
const getClassByFloor=async (req,res)=>{
    try{
        const classByFloor=await Classes.find({floor:req.params.floor});
        if(classByFloor.length===0){
            return res.status(204).json({message:"Class not found"})
        }
        return res.status(200).json(classByFloor)
    }
    catch(err){
        res.status(500).json({message:err.message})
    }
}


module.exports={
    addClass,
    getAllClasses,
    deleteClass,
    updateClass,
    getClassByName,
    getClassByFloor
    
}