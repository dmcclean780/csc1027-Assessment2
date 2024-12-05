// Check if the selected hall has changed and display exhibits in that hall
window.onload = () => {
    const hallSelector = document.getElementById("hallChoice");
    hallSelector.addEventListener('change', () => {
        const hall = hallSelector.value
        const monthGrid = document.getElementById('monthGrid');
        const oldHall = document.getElementById('hall')
        const hallBox = document.createElement('div');
        hallBox.innerHTML = hallSelector.options[hallSelector.selectedIndex].text
        hallBox.id = 'hall'
        hallBox.className = 'bg-green-500 border-t-2 border-r-2 border-b pl-2 font-bold'
        monthGrid.replaceChild(hallBox, oldHall)
        for (let i = 0; i < exhibitPlan.length; i++) {
            const oldExhibit = document.getElementById('exhibit'+i)
            const exhibitBox = document.createElement('div');
            exhibitBox.innerHTML = exhibitPlan[i][hall]
            exhibitBox.id = 'exhibit'+i
            const colour = (i%2==1) ? "green" : "gray";
            const borderBottom = (i%(exhibitPlan.length-1)==0 && i!=0) ? 'border-b-2' : ""
            exhibitBox.className = 'bg-'+colour+'-400 border-r-2 pl-2 '+borderBottom
            monthGrid.replaceChild(exhibitBox, oldExhibit)
        }

    })
};