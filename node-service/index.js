require("dotenv").config();
const {registerWithEureka}=require("./src/eureka-client")
var express = require("express");
require("./src/dataBase")
var cors = require("cors");
var app = express();
const route=require("./src/routes");
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cors());
app.use("/classes", route);
app.listen(process.env.PORT || 5000 , () => {
  console.log(`Server running on port ${process.env.PORT || 5000}`); 
});
registerWithEureka("node-service",process.env.PORT || 5000);
