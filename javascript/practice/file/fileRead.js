var inputfile = document.getElementById("file");
inputfile.addEventListener("change", (e) => {
  const file = e.target.files[0];
  const reader = new FileReader();

  reader.addEventListener("load", (e) => {
    console.log(JSON.parse(e.target.result));
  });
  reader.addEventListener("progress", (event) => {
    if (event.loaded && event.total) {
      const percent = (event.loaded / event.total) * 100;
      console.log(`Progress: ${Math.round(percent)}`);
    }
  });
  reader.readAsText(file);

  console.log();
});
