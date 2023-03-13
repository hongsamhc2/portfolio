const canvas = document.querySelector("canvas");
canvas.width = window.innerWidth;
const ctx = canvas.getContext("2d");
var hRatio;
var img;
const inputfile = document.getElementById("file");
inputfile.addEventListener("change", (e) => {
  const file = e.target.files[0];
  const reader = new FileReader();
  reader.addEventListener("load", (e) => {
    img = new Image();
    img.addEventListener("load", (e) => {
      ctx.clearRect(0, 0, canvas.width, canvas.height);
      drawImage(img);
    });
    img.src = e.target.result;
  });

  reader.readAsDataURL(file);
});

// calculate where the canvas is on the window
// (used to help calculate mouseX/mouseY)
var canvasOffset = canvas.getBoundingClientRect();
var offsetX;
var offsetY;

// this flage is true when the user is dragging the mouse
var isDown = false;

// these vars will hold the starting mouse position
var startX;
var startY;
ctx.strokeRect(0, 0, 10, 10);
// var x1 = null
// var x2 = null
// var y1 = null
// var y2 = null

function handleMouseDown(e) {
  e.preventDefault();
  e.stopPropagation();
  offsetX = canvasOffset.left;
  offsetY = canvasOffset.top;
  console.log(e);

  // save the starting x/y of the rectangle
  startX = parseInt(e.layerX - offsetX);
  startY = parseInt(e.layerY - offsetY);
  // set a flag indicating the drag has begun
  isDown = true;
}

function handleMouseUp(e) {
  e.preventDefault();
  e.stopPropagation();

  // the drag is over, clear the dragging flag
  isDown = false;
  console.log(mouseX, mouseY, startX, startY, ratio);
  // console.log(x1, x2, y1, y2)
}

function handleMouseOut(e) {
  e.preventDefault();
  e.stopPropagation();

  // the drag is over, clear the dragging flag
  isDown = false;
}

function handleMouseMove(e) {
  e.preventDefault();
  e.stopPropagation();
  // if we're not dragging, just return
  if (!isDown) {
    return;
  }

  // get the current mouse position
  mouseX = parseInt(e.layerX - offsetX);
  mouseY = parseInt(e.layerY - offsetY);

  // Put your mousemove stuff here

  // clear the canvas
  ctx.clearRect(0, 0, canvas.width, canvas.height);

  // calculate the rectangle width/height based
  // on starting vs current mouse position
  var width = mouseX - startX;
  var height = mouseY - startY;

  // draw a new rect from the start position
  // to the current mouse position
  drawImage(img);
  ctx.restore;
  ctx.strokeStyle = "#3eddff";
  ctx.lineWidth = 2;
  ctx.strokeRect(startX, startY, width, height);
  // style the context
  ctx.save();
}

canvas.addEventListener("mousedown", function (e) {
  handleMouseDown(e);
});
canvas.addEventListener("mousemove", function (e) {
  handleMouseMove(e);
});
canvas.addEventListener("mouseup", function (e) {
  handleMouseUp(e);
});
canvas.addEventListener("mouseout", function (e) {
  handleMouseOut(e);
});
var ratio;
function drawImage(img) {
  hRatio = canvas.width / img.width;
  canvas.height = img.height * hRatio;
  ratio = hRatio;
  ctx.drawImage(
    img,
    0,
    0,
    img.width,
    img.height,
    0,
    0,
    img.width * ratio,
    img.height * ratio
  );
}
